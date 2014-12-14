package cn.flower.tick.service;

import java.io.Serializable;
import java.util.List;

import cn.flower.tick.model.biz.Passenger;
import cn.flower.tick.model.system.User;

public interface IPassengerService {
	public void save(Passenger passenger);
	public void update(Passenger passenger);
	public void delete(Serializable id);
	public Passenger query(String name);
	public List<Object> showAllBySql(User user) ;
	public List<Passenger> showAll(User user); 
}
