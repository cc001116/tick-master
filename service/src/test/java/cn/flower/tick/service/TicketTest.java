package cn.flower.tick.service;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.flower.tick.model.biz.Order;
import cn.flower.tick.model.biz.Passenger;
import cn.flower.tick.model.biz.Ticket;
import cn.flower.tick.model.system.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-service-config.xml")
public class TicketTest {
	
	@Autowired
	private ITicketService ticketService;
	@Test
	public void save() {
		User user = new User();
		user.setId(1L);
		Ticket ticket = new Ticket();
		Order order = new Order();
		order.setCreateDate(new Date());
		order.setAccount(223);
		order.setCreateUser(user);
		ticket.setOrder(order);
		Passenger passenger = new Passenger();
		passenger.setCreateUser(user);
		passenger.setIdCard("00000012");
		ticket.setPassenger(passenger);
		ticket.setSerialCode(null);
		ticketService.saveOrUpdate(ticket);
	}
}
