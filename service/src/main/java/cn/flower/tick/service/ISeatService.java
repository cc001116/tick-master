package cn.flower.tick.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import cn.flower.tick.model.biz.Seat;
import cn.flower.tick.model.biz.Train;

public interface ISeatService {
	public void saveOrUpdate(Seat seat);
	public void saveOrUpdate(Collection<Seat> seats);
	public void delete(Serializable...ids);
	
	public Seat query(Long id);
	@SuppressWarnings("rawtypes")
	public List queryUnsoldSeat(Train train, String date);
	@SuppressWarnings("rawtypes")
	List queryUnsoldSeat(String fromStation, String toStation, String startDate);
}
