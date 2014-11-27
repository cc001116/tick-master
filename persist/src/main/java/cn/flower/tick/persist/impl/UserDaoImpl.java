package cn.flower.tick.persist.impl;

import org.springframework.stereotype.Repository;

import cn.flower.tick.model.system.User;
import cn.flower.tick.persist.IUserDao;

@Repository
public class UserDaoImpl extends CommonDaoImpl<User> implements IUserDao{

}
