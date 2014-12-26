package cn.flower.tick.web.backed;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.flower.tick.model.biz.Price;
import cn.flower.tick.model.biz.Room;
import cn.flower.tick.model.biz.Seat;
import cn.flower.tick.model.biz.SeatType;
import cn.flower.tick.model.biz.Train;
import cn.flower.tick.service.IPriceService;
import cn.flower.tick.service.IRoomService;
import cn.flower.tick.service.ISeatService;
import cn.flower.tick.service.ISeatTypeService;
import cn.flower.tick.service.ITicketService;
import cn.flower.tick.service.ITrainService;
import cn.flower.tick.util.DateUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-service-config.xml")
public class Init {

	@Autowired
	private ISeatTypeService seatTypeService;
	@Autowired
	private ISeatService seatService;
	@Autowired
	private ITrainService trainService;
	@Autowired
	private ITicketService ticketService;
	@Autowired
	private IRoomService roomService;
	@Autowired
	private IPriceService priceService;
	
	String startingStation = "北京";
	String[] destinations = { "周口", "南阳", "驻马店", "邵阳" };

	@Test
	public void init() {
		initSeatType();
		initTrain();
		initRooms();
		initSeats();
		initPrice();
	}
	
	private void initSeatType() {
		String[] types = { "硬座", "软座", "硬卧", "软卧" };

		for (String t : types) {
			SeatType type = new SeatType();
			type.setTypeName(t);
			type.setDescription(t);
			seatTypeService.saveOrUpdate(type);
		}
	}

	
	private void initTrain() {
	
		Random random = new Random();
		List<Train> trains = new ArrayList<Train>();
		for (int i = 0; i < destinations.length; i++) {
			int c = random.nextInt(5)+1;
			for (int j = 0; j < c; j++) {
				Train t = new Train();
				t.setStartingStation(startingStation);
				t.setDestination(destinations[i]);
				t.setNumber("k" + random.nextInt(1000));
				t.setRoomNum(18);
				trains.add(t);
			}
		}
		this.trainService.saveOrUpdate(trains);
	}
	
	
	private void initRooms() {
		List<Train> trains = this.trainService.showAll();
		List<SeatType> types = this.seatTypeService.showAll();
		List<Room> rooms = new ArrayList<Room>();
		Random rd = new Random();
		for(Train t : trains) {
			for (int i = 0; i < t.getRoomNum(); i++) {
				Room room = new Room();
				room.setName(i+1+"");
				room.setTrain(t);
				room.setSeatNum(90+rd.nextInt(40));
				room.setSeatType(types.get(i/5));
				rooms.add(room);
			}
		}
		roomService.saveOrUpdate(rooms);
	}
	
	
	private void initSeats() {
		List<Train> trains = this.trainService.showAll();
		List<Seat> seats = new ArrayList<Seat>();		
		for(Train t : trains) {
			Set<Room> rooms = t.getRooms();
			for(Room room : rooms) {
				for (int i = 0; i < room.getSeatNum(); i++) {
					Seat seat = new Seat();
					seat.setRoom(room);
					seat.setSeatNo(i+1);
					seats.add(seat);
				}
			}
		}
		this.seatService.saveOrUpdate(seats);
	}
	
	
	private void initPrice() {
		List<Train> trains = this.trainService.showAll();
		List<SeatType> types = this.seatTypeService.showAll();
		List<Price> prices = new ArrayList<Price>();
		Random random = new Random();
		for(Train train : trains) {
			Date date = DateUtils.parseDate("2014-12-07 00:00", "yyyy-MM-dd HH:mm");
			date = DateUtils.addHours(date, random.nextInt(24));
			date = DateUtils.addMinutes(date, random.nextInt(60));
			for(SeatType seatType : types) {
				Price p = new Price();
				p.setArrivalStation(train.getDestination());
				p.setDepartureStation(train.getStartingStation());
				p.setDepartureTime(DateUtils.format(date, "HH:mm"));
				p.setPrice(100+random.nextInt(50)+ (int)(30*seatType.getId() * 0.3));
				p.setTrain(train);
				p.setSeatType(seatType);
				prices.add(p);
			}
		}
		this.priceService.saveOrUpdate(prices);
	}
}
