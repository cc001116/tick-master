package cn.flower.tick.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.flower.tick.model.biz.Passenger;
import cn.flower.tick.model.system.User;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> showAllBySql(User user) {
		String sql = "SELECT * FROM passenger p WHERE p.create_user = ?; ";
		return dao.findCollectionBySql(sql, user.getId());
	}

	@Override
	public List<Passenger> showAll(User user) {
		String hql = "WHERE o.createUser.id = ?";
		return (List<Passenger>) dao.findCollectionByHql(hql, new Object[]{ user.getId()}, null);
	}
	

}
