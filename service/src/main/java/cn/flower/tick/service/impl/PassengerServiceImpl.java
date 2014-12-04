package cn.flower.tick.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.flower.tick.model.biz.Passenger;
import cn.flower.tick.persist.IPassengerDao;
import cn.flower.tick.service.IPassengerService;

@Transactional(readOnly = true)
@Service
public class PassengerServiceImpl implements IPassengerService {

	@Autowired
	private IPassengerDao dao;
	
	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void save(Passenger passenger) {
		dao.save(passenger);
	}

	@Override	
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void update(Passenger passenger) {
		dao.saveOrUpdate(passenger);
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(Serializable id) {
		dao.deleteObjectByIds(id);
	}

	@Override
	public Passenger query(String name) {
		String hql = "where o.name = ?";
		return dao.findObjectByHql(hql, name);
	}

	@Override
	public List<Passenger> showAll() {
		
		return (List<Passenger>) dao.findCollectionByHql(null, null, null);
	}

}
