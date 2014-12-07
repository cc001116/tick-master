package cn.flower.tick.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.flower.tick.model.biz.SeatType;
import cn.flower.tick.persist.ISeatTypeDao;
import cn.flower.tick.service.ISeatTypeService;

@Service
@Transactional(readOnly = true)
public class SeatTypeServiceImpl implements ISeatTypeService{

	@Autowired
	private ISeatTypeDao seatTypeDao;
	
	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void saveOrUpdate(SeatType seatType) {
		seatTypeDao.saveOrUpdate(seatType);
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(Serializable... ids) {
		seatTypeDao.deleteObjectByIds(ids);
	}

	@Override
	public List<SeatType> showAll() {
		return (List<SeatType>) seatTypeDao.findCollectionByHql(null, null, null);
	}

	@Override
	public SeatType query(Long id) {
		return seatTypeDao.findObjectById(id);
	}

}
