package cn.flower.tick.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.flower.tick.model.biz.Order;
import cn.flower.tick.model.biz.Passenger;
import cn.flower.tick.model.biz.Ticket;
import cn.flower.tick.model.enums.OrderState;
import cn.flower.tick.model.system.User;
import cn.flower.tick.persist.IOrderDao;
import cn.flower.tick.service.IOrderService;
import cn.flower.tick.util.DateUtils;

@Service
@Transactional(readOnly = true)
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private IOrderDao orderDao;

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void saveOrUpdate(Order order) {
		this.orderDao.saveOrUpdate(order);
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(Serializable... ids) {
		this.orderDao.deleteObjectByIds(ids);
	}

	@Override
	public Order query(Long id) {
		return this.orderDao.findObjectById(id);
	}

	@Override
	public Order query(String serialCode) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private List<Order> queryOrderByUser(User user, OrderState state) {
		Long userId = user.getId();
		String hql = "WHERE o.state = ? AND o.createUser.id = ?";
		List<Order> orders =  (List<Order>) this.orderDao.findCollectionByHql(hql,
				new Object[] { state.value, userId },
				null);
		return orders;
	}

	@Override
	public List<Map<String, Object>> queryUncompleteOrderByUser(User user) {
		Long userId = user.getId();
		String hql = "WHERE o.state = ? AND o.createUser.id = ?";
		List<Order> orders =  (List<Order>) this.orderDao.findCollectionByHql(hql,
				new Object[] { OrderState.UNCOMPLETE.value, userId },
				null);
		return extractField(orders);
	}

	private List<Map<String, Object>> extractField(List<Order> orders) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for(Order order : orders) {
			Map<String, Object> map =  new HashMap<String, Object>();
			map.put("id", order.getId());
			map.put("serialCode", order.getSerialCode());
			map.put("createDate", DateUtils.format(order.getCreateDate(), "yyyy-MM-dd HH:mm:ss"));
			Set<Ticket> tickets = order.getTickets();
			for(Ticket t : tickets) {
				Map<String, Object> tick = new HashMap<String , Object>();
				tick.put("seatNo", t.getSeat().getSeatNo());
				tick.put("roomNo", t.getSeat().getRoom().getName());
				tick.put("tickSerialCode", t.getSerialCode());
				tick.put("passenger",t.getPassenger().getName());
				tick.put("startDate", DateUtils.format(t.getStartDate(), "yyyy-MM-dd HH:mm:ss"));
				tick.put("tickPrice", t.getPrice().getPrice());
				tick.put("startStation", t.getPrice().getDepartureStation());
				tick.put("arrivalStation", t.getPrice().getArrivalStation());
				tick.put("typeName", t.getPrice().getSeatType().getTypeName());
				map.put("ticket", tick);
			}
			list.add(map);
		}
		
		return list;
	}
	
	public List<Order> queryOrderByPassenger(Passenger passenger, OrderState state) {
		String hql = "WHERE o.passenger.id = ? AND o.state = ?";
		return (List<Order>) this.orderDao.findCollectionByHql(hql,
				new Object[] { passenger.getId(), state.value },
				null);
	}
	
	@Override
	public List<Order> queryUncompleteOrderByPassenger(Passenger passenger) {
		return queryOrderByPassenger(passenger, OrderState.UNCOMPLETE);
	}

	@Override
	public List<Map<String, Object>> queryCompletedOrderByUser(User user) {
		Long userId = user.getId();
		String hql = "WHERE o.state = ? AND o.createUser.id = ?";
		List<Order> orders =  (List<Order>) this.orderDao.findCollectionByHql(hql,
				new Object[] { OrderState.COMPLETED.value, userId },
				null);
		return extractField(orders);
	}

	@Override
	public List<Order> queryCompletedOrderByPassenger(Passenger passenger) {
		return queryOrderByPassenger(passenger, OrderState.COMPLETED);
	}

}
