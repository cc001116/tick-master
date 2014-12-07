package cn.flower.tick.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.flower.tick.model.biz.Seat;
import cn.flower.tick.model.biz.Train;
import cn.flower.tick.persist.ISeatDao;
import cn.flower.tick.service.ISeatService;

@Service
@Transactional(readOnly = true)
public class SeatServiceImpl implements ISeatService {

	@Autowired
	private ISeatDao seatDao;

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void saveOrUpdate(Seat seat) {
		this.seatDao.saveOrUpdate(seat);
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void saveOrUpdate(Collection<Seat> seats) {
		this.seatDao.saveOrUpdateAll(seats);
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(Serializable... ids) {
		this.seatDao.deleteObjectByIds(ids);
	}

	@Override
	public Seat query(Long id) {
		return this.seatDao.findObjectById(id);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List queryUnsoldSeat(Train train, String date) {

		String sql = "SELECT train, seat_type.type_name, count(*) " + "FROM ("
				+ "SELECT * FROM seat where seat.id NOT IN"
				+ "(SELECT seat from ticket where ticket.start_date = ?)"
				+ ") unsold, room, seat_type "
				+ "WHERE unsold.room = room.id AND room.train = ? "
				+ "AND seat_type.id = room.seat_type GROUP BY room.seat_type";
		return this.seatDao.findCollectionBySql(sql, date, train.getId());
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List queryUnsoldSeat(String fromStation, String toStation, String startDate) {
		String sql = "SELECT room.train, seat_type.id, seat_type.type_name, price , departure_time,count(*) "
				+ "FROM (SELECT * FROM seat where seat.id NOT IN "
				+ "(SELECT seat from ticket where ticket.start_date like ?)) unsold, room, seat_type, price "
				+ "WHERE unsold.room = room.id "
				+ "AND seat_type.id = room.seat_type "
				+ "AND room.train = price.train "
				+ "AND price.seat_type = room.seat_type AND price.departure_station = ? "
				+ "AND price.arrival_station = ? " 
				+ "GROUP BY room.train, room.seat_type "
				+ "ORDER BY departure_time, seat_type.id";
		return this.seatDao.findCollectionBySql(sql, startDate, fromStation, toStation);
	}
}
