package cn.flower.tick.service;

import java.io.Serializable;
import java.util.List;

import cn.flower.tick.model.biz.Passenger;

public interface IPassengerService {
	public void save(Passenger passenger);
	public void update(Passenger passenger);
	public void delete(Serializable id);
	public Passenger query(String name);
	public List<Passenger> showAll() ;
}
