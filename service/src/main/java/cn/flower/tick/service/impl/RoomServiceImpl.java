package cn.flower.tick.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.flower.tick.model.biz.Room;
import cn.flower.tick.model.biz.Train;
import cn.flower.tick.persist.IRoomDao;
import cn.flower.tick.service.IRoomService;

@Service
@Transactional(readOnly = true)
public class RoomServiceImpl implements IRoomService{

	@Autowired
	private IRoomDao roomDao;
	
	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void saveOrUpdate(List<Room> list) {
		roomDao.saveOrUpdateAll(list);
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(Serializable... ids) {
		roomDao.deleteObjectByIds(ids);
	}



	@Override
	public Room queryById(Serializable id) {
		return roomDao.findObjectById(id);
	}

	@Override
	public List<Room> queryByTrain(Train train) {
		String hql = "WHERE o.train = ?";
		return (List<Room>) roomDao.findCollectionByHql(hql, new Object[]{train}, null);
	}

}
