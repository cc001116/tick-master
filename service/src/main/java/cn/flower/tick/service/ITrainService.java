package cn.flower.tick.service;

import java.util.Collection;
import java.util.List;

import cn.flower.tick.model.biz.Train;

public interface ITrainService {
	public void saveOrUpdate(Train train);
	public void saveOrUpdate(Collection<Train> trains);
	public Train query(Long id);
	public Train query(String number);
	public List<Train> showAll();
}
