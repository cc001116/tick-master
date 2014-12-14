package cn.flower.tick.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.flower.tick.model.biz.Passenger;
import cn.flower.tick.model.biz.Ticket;
import cn.flower.tick.model.system.User;
import cn.flower.tick.persist.ITicketDao;
import cn.flower.tick.service.ITicketService;

@Service
@Transactional(readOnly = true)
public class TicketServiceImpl implements ITicketService{

	@Autowired
	private ITicketDao ticketDao;
	
	@Override
	public Ticket query(Long id) {
		return ticketDao.findObjectById(id);
	}

	@Override
	public Set<Ticket> query(Passenger passenger) {
		return null;
	}

	@Override
	public List<Ticket> queryByPassenger(Long id) {
		String hql = "WHERE o.passenger.id = ?";
		return (List<Ticket>) ticketDao.findCollectionByHql(hql, new Object[]{id}, null);
	}

	@Override
	public List<Ticket> query(User user) {
		
		String hql = "WHERE o.order.createUser.id = ?";
		return (List<Ticket>) ticketDao.findCollectionByHql(hql, new Object[]{user.getId()}, null);
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void saveOrUpdate(Ticket ticket) {
		ticketDao.saveOrUpdate(ticket);
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void saveOrUpdate(Collection<Ticket> tickets) {
		ticketDao.saveOrUpdateAll(tickets);
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(Ticket ticket) {
		delete(ticket.getId());
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(Serializable... ids) {
		ticketDao.deleteObjectByIds(ids);
	}

}
