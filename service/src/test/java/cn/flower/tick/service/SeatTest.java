package cn.flower.tick.service;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mysql.fabric.xmlrpc.base.Data;

import cn.flower.tick.model.biz.Seat;
import cn.flower.tick.model.biz.Train;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-service-config.xml")
public class SeatTest {
	@Autowired
	private ISeatService seatService;

	/*@SuppressWarnings("rawtypes")
	@Test
	public void queryUnsoldTicket() {
		Train train = new Train();
		train.setId(1L);
		List seats = seatService.queryUnsoldSeat(train, "2014-12-7");
		for (int i = 0; i < seats.size(); i++) {
			Object[] objs = (Object[]) seats.get(i);
			for(Object o : objs) {
				System.out.print(o+"  ");
			}
			System.out.println();
		}
	}*/
	
	@Test
	public void queryUnsoldTicketByStation() {
		List seats = seatService.queryUnsoldSeats("北京", "南阳", "2014-12-07");
		for (int i = 0; i < seats.size(); i++) {
			Object[] objs = (Object[]) seats.get(i);
			for(Object o : objs) {
				System.out.print(o+"  ");
			}
			System.out.println();
		}
	}

	private void print(List seats) {
		for (int i = 0; i < seats.size(); i++) {
			
			Seat s = (Seat) seats.get(i);
			/*System.out.println(s.getSeatNo() + "车箱： " + s.getRoom().getName() + "车： "
					+ s.getRoom().getTrain().getDestination()+"-"+s.getRoom().getTrain().getStartingStation());*/
		}
	}
}
