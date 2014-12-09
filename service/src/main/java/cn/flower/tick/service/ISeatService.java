package cn.flower.tick.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import cn.flower.tick.model.biz.Seat;

public interface ISeatService {
	public void saveOrUpdate(Seat seat);
	public void saveOrUpdate(Collection<Seat> seats);
	public void delete(Serializable...ids);
	
	public Seat query(Long id);
	@SuppressWarnings("rawtypes")
	public List queryUnsoldSeats(Long trainId, Long seatTypeId, String date, Integer size);
	@SuppressWarnings("rawtypes")
	List queryUnsoldSeats(String fromStation, String toStation, String startDate);
	public Seat queryUnsoldSeat(Long trainId, Long seatTypeId, String date) ;

}
