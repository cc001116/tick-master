package cn.flower.tick.persist.impl;

import org.springframework.stereotype.Repository;

import cn.flower.tick.model.biz.Passenger;
import cn.flower.tick.persist.IPassengerDao;

@Repository
public class PassengerDaoImpl extends CommonDaoImpl<Passenger> implements IPassengerDao {

}
