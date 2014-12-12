package cn.flower.tick.web.biz;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.flower.tick.model.biz.Order;
import cn.flower.tick.model.enums.OrderState;
import cn.flower.tick.model.system.User;
import cn.flower.tick.service.IOrderService;
import cn.flower.tick.web.base.BaseController;

@Controller
@RequestMapping("/order")
public class OrderController extends BaseController {

	@Autowired
	private IOrderService orderService;

	@RequestMapping("/delete/{id}")
	@ResponseBody
	public String delete(@PathVariable Long id) {
		orderService.delete(id);
		return SUCCESS;
	}

	@RequestMapping("/pay/{id}")
	@ResponseBody
	public String pay(@PathVariable Long id) {
		Order order =  orderService.query(id);
		order.setState(OrderState.COMPLETED.value);
		orderService.saveOrUpdate(order);
		return SUCCESS;
	}
	
	@RequestMapping(value = "/view/uncomplete", method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String, Object>> queryUnCompletedOrders(HttpServletRequest request) {
		User user = getSessionUser(request);
		List<Map<String, Object>> list = orderService.queryUncompleteOrderByUser(user);
		return list;
	}

	@RequestMapping("/view/completed")
	@ResponseBody
	public List<Map<String, Object>> queryCompletedOrders(HttpServletRequest request) {
		User user = getSessionUser(request);
		List<Map<String, Object>> list = orderService.queryCompletedOrderByUser(user);
		return list;
	}
}
