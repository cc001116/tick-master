package cn.flower.tick.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.flower.tick.model.biz.Train;
import cn.flower.tick.persist.ITrainDao;
import cn.flower.tick.service.ITrainService;

@Service
@Transactional(readOnly = true)
public class TrainServiceImpl implements ITrainService{

	@Autowired
	private ITrainDao trainDao;
	
	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void saveOrUpdate(Train train) {
		trainDao.save(train);
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void saveOrUpdate(Collection<Train> trains) {
		trainDao.saveOrUpdateAll(trains);
	}

	@Override
	public Train query(Long id) {
		return trainDao.findObjectById(id);
	}
	
	@Override
	public Train query(String number) {
		String hql = "WHERE o.number = ?";
		return trainDao.findObjectByHql(hql, number);
	}

	@Override
	public List<Train> showAll() {
		return (List<Train>) trainDao.findCollectionByHql(null, null, null);
	}

}
