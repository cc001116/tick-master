package cn.flower.tick.persist.impl;

import org.springframework.stereotype.Repository;

import cn.flower.tick.model.biz.Price;
import cn.flower.tick.persist.IPriceDao;

@Repository
public class PriceDaoImpl extends CommonDaoImpl<Price> implements IPriceDao{

}
