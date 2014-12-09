package cn.flower.tick.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.flower.tick.model.biz.Price;
import cn.flower.tick.persist.IPriceDao;
import cn.flower.tick.service.IPriceService;

@Service
@Transactional(readOnly = true)
public class PriceServiceImpl implements IPriceService {

	@Autowired
	private IPriceDao priceDao;

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void saveOrUpdate(Price price) {
		priceDao.saveOrUpdate(price);
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void saveOrUpdate(Collection<Price> prices) {
		priceDao.saveOrUpdateAll(prices);
	}
	
	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(Serializable... ids) {
		priceDao.deleteObjectByIds(ids);
	}

	@Override
	public List<Price> query(String fromStation, String toStation) {
		String hql = "WHERE o.getdepartureStation =?  AND o.arrivalStation = ?";
		return (List<Price>) priceDao.findCollectionByHql(hql, new Object[] { fromStation,
				toStation }, null);
	}

	@Override
	public List<Price> query(String trainNumber) {
		String hql = "WHERE o.train.number = ?";
		return (List<Price>) priceDao.findCollectionByHql(hql, new Object[]{trainNumber}, null);
	}

	@Override
	public Price query(Long trainId, Long seatTypeId) {
		String hql = "WHERE o.train.id = ? AND o.seatType.id = ?";
		return priceDao.findObjectByHql(hql, trainId, seatTypeId);
	}



}
