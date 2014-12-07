package cn.flower.tick.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import cn.flower.tick.model.biz.Passenger;
import cn.flower.tick.model.biz.Ticket;
import cn.flower.tick.model.system.User;

public interface ITicketService {
	public Ticket query(Long id);
	public Set<Ticket> query(Passenger passenger);
	public List<Ticket> queryByPassenger(Long id);
	public List<Ticket> query(User user);
	
	public void saveOrUpdate(Ticket ticket);
	public void saveOrUpdate(Collection<Ticket> tickets);
	
	public void delete(Ticket ticket);
	public void delete(Serializable...ids);
}
