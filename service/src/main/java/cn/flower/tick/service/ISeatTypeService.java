package cn.flower.tick.service;

import java.io.Serializable;
import java.util.List;

import cn.flower.tick.model.biz.SeatType;

public interface ISeatTypeService {
	public void saveOrUpdate(SeatType seatType);
	public void delete(Serializable...ids);
	public List<SeatType> showAll();
	public SeatType query(Long id); 
}
