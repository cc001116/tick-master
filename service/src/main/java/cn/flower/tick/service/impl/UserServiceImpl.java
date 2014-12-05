package cn.flower.tick.service.impl;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.flower.tick.model.system.User;
import cn.flower.tick.persist.IUserDao;
import cn.flower.tick.service.IUserService;

@Transactional(readOnly = true)
@Service("userService")
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private IUserDao userDao;
	
	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void register(User user) {
		this.saveOrUpdate(user);
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void saveOrUpdate(User... users) {
		for (User user : users) {
			this.userDao.saveOrUpdate(user);
		}
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(Serializable... ids) {
		this.userDao.deleteObjectByIds(ids);
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(Collection<User> users) {
		this.userDao.deleteObjectByCollection(users);
	}

	@Override
	public User queryById(Serializable id) {
		return this.userDao.findObjectById(id);
	}

	@Override
	public User query(String username) {
		String hql = "WHERE o.username = ?";
		return this.userDao.findObjectByHql(hql, username);
	}

	
}
