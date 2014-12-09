package cn.flower.tick.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import cn.flower.tick.model.biz.Order;
import cn.flower.tick.model.biz.Passenger;
import cn.flower.tick.model.system.User;

public interface IOrderService {
	void saveOrUpdate(Order order);
	
	void delete(Serializable...ids);
	
	List<Map<String, Object>> queryUncompleteOrderByUser(User user);
	
	List<Order> queryUncompleteOrderByPassenger(Passenger passenger);
	
	List<Map<String, Object>> queryCompletedOrderByUser(User user);
	
	List<Order> queryCompletedOrderByPassenger(Passenger passenger);
	
	Order query(Long id);
	
	Order query(String serialCode);
}
