package cn.flower.tick.persist.impl;

import org.springframework.stereotype.Repository;

import cn.flower.tick.model.biz.Order;
import cn.flower.tick.persist.IOrderDao;

@Repository
public class OrderDaoImpl extends CommonDaoImpl<Order> implements IOrderDao{

}
