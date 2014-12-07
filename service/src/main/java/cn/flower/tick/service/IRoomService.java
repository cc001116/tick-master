package cn.flower.tick.service;

import java.io.Serializable;
import java.util.List;

import cn.flower.tick.model.biz.Room;
import cn.flower.tick.model.biz.Train;

public interface IRoomService {
	void saveOrUpdate(List<Room> list);
	void delete(Serializable...ids);
	List<Room> queryByTrain(Train train);
	Room queryById(Serializable id);
}
