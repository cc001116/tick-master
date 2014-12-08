package cn.flower.tick.web.biz;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.flower.tick.service.ISeatService;
import cn.flower.tick.web.base.BaseController;

@Controller
@RequestMapping("/ticket")
public class TicketController extends BaseController {

	@Autowired
	private ISeatService seatService;

	@SuppressWarnings("rawtypes")
	@RequestMapping("/view/unsold/{from}/{to}/{date}")
	@ResponseBody
	public List queryUnsoldTicket(@PathVariable String from,
			@PathVariable String to, @PathVariable String date) {
		List list =  seatService.queryUnsoldSeats(convertCharSet(from), convertCharSet(to), date);
		return list;
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
