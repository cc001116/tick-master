package cn.flower.tick.web.biz;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.flower.tick.model.biz.Order;
import cn.flower.tick.model.biz.Passenger;
import cn.flower.tick.model.biz.Price;
import cn.flower.tick.model.biz.Seat;
import cn.flower.tick.model.biz.Ticket;
import cn.flower.tick.model.enums.OrderState;
import cn.flower.tick.model.system.User;
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
		List list = seatService.queryUnsoldSeats(convertCharSet(from),
				convertCharSet(to), date);
		return list;
	}

	@RequestMapping("/save")
	@ResponseBody
	public Map<String, Object> save(HttpServletRequest request, 
			@RequestParam(value = "passengerId") Long passengerId,
			@RequestParam(value = "trainId") Long trainId,
			@RequestParam(value = "seatTypeId") Long seatTypeId,
			@RequestParam(value = "date") String date) {
		Seat seat = getSeat(trainId, seatTypeId, date);
		User user = getSessionUser(request);
		Order order = crateOrder(user);
		Map<String, Object> map = new HashMap<String, Object>();
		if (seat != null) {
			Ticket ticket = new Ticket();
			ticket.setPassenger(getPassenger(passengerId));
			ticket.setPrice(getPrice(trainId, seatTypeId));
			ticket.setSeat(seat);
			ticket.setSerialCode(UUID.randomUUID().toString());
			ticket.setStartDate(DateUtils.parseDate(date, "yyyy-MM-dd"));
			order.setAccount(ticket.getPrice().getPrice());
			ticket.setOrder(order);
			this.ticketService.saveOrUpdate(ticket);
			map.put("msg", SUCCESS);
			map.put("orderCode", order.getSerialCode());
			map.put("price", order.getAccount());
		}else {
			map.put("msg", "余票不足");
		}
		return map;
	}

	private Passenger getPassenger(Long passengerId) {
		Passenger passenger = new Passenger();
		passenger.setId(passengerId);
		return passenger;
	}

	private Order crateOrder(User user) {
		Order order = new Order();
		order.setSerialCode(UUID.randomUUID().toString().substring(19, 31));
		order.setCreateUser(user);
		order.setCreateDate(new Date());
		order.setState(OrderState.UNCOMPLETE.value);
		return order;
	}
	
	private Seat getSeat(Long trainId, Long seatTypeId, String date) {
		return this.seatService.queryUnsoldSeat(trainId, seatTypeId, date);
	}

	private Price getPrice(Long trainId, Long seatTypeId) {
		return this.priceService.query(trainId, seatTypeId);
	}

	private String convertCharSet(String msg) {
		String target = null;
		try {
			target = new String(msg.getBytes("ISO8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return target;
	}
}
