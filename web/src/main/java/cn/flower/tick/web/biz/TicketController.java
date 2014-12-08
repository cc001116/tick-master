package cn.flower.tick.web.biz;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.flower.tick.model.biz.Passenger;
import cn.flower.tick.model.biz.Price;
import cn.flower.tick.model.biz.Seat;
import cn.flower.tick.model.biz.Ticket;
import cn.flower.tick.service.IPriceService;
import cn.flower.tick.service.ISeatService;
import cn.flower.tick.service.ITicketService;
import cn.flower.tick.util.DateUtils;
import cn.flower.tick.web.base.BaseController;

@Controller
@RequestMapping("/ticket")
public class TicketController extends BaseController {

	@Autowired
	private ISeatService seatService;
	@Autowired
	private ITicketService ticketService;
	@Autowired
	private IPriceService priceService;
	
	@SuppressWarnings("rawtypes")
	@RequestMapping("/view/unsold/{from}/{to}/{date}")
	@ResponseBody
	public List queryUnsoldTicket(@PathVariable String from,
			@PathVariable String to, @PathVariable String date) {
		List list =  seatService.queryUnsoldSeats(convertCharSet(from), convertCharSet(to), date);
		return list;
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public void save(Long passengerId, Long trainId, Long seatTypeId, String date) {
		Ticket ticket = new Ticket();
		Passenger passenger = new Passenger();
		passenger.setId(passengerId);
		ticket.setPassenger(passenger);
		ticket.setPrice(getPrice(trainId, seatTypeId));
		ticket.setSeat(getSeat());
		ticket.setSerialCode(UUID.randomUUID().toString());
		ticket.setStartDate(DateUtils.parseDate(date, "yyyy-MM-dd"));
	}
	
	private Seat getSeat() {
		return null;
	}
	
	private Price getPrice(Long trainId, Long seatTypeId) {
		return this.priceService.query(trainId, seatTypeId);
	}
	
	private String convertCharSet(String msg) {
		String target = null;
		try {
			target =  new String(msg.getBytes("ISO8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return target;
	}
}
