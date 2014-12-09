package cn.flower.tick.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import cn.flower.tick.model.biz.Price;

public interface IPriceService {
	public void saveOrUpdate(Price price);
	
	public void saveOrUpdate(Collection<Price> prices);
	
	public void delete(Serializable...ids);
	
	public List<Price> query(String fromStation, String toStation);
	
	public List<Price> query(String trainNumber);
	
	public Price query(Long trainId, Long seatTypeId);
	
}
