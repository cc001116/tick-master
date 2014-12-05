package cn.flower.tick.service;

import java.io.Serializable;
import java.util.Collection;

import cn.flower.tick.model.system.User;

public interface IUserService {

	/**
	 * 注册用户
	 * @param user
	 */
	public void register(final User user);

	/**
	 * 更新用户
	 * @param users 待更新的用户（可以指定多个）
	 */
	public void saveOrUpdate(final User ...users);
	
	/**
	 * 删除给定ID的用户（可以指定多个）
	 * @param ids
	 */
	public void delete(Serializable...ids);
	
	/**
	 * 删除对象
	 * @param users 
	 */
	public void delete(final Collection<User> users);
	
	/**
	 * 依ID查询用户
	 * @param id
	 * @return
	 */
	public User queryById(Serializable id);
	
	/**
	 * 依名字查询用户
	 * @param username
	 * @return
	 */
	public User query(String username);
}
