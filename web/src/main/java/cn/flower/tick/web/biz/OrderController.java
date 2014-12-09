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

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;

import cn.flower.tick.model.biz.Order;
import cn.flower.tick.model.system.User;
import cn.flower.tick.service.IOrderService;
import cn.flower.tick.web.base.BaseController;

@Controller
@RequestMapping("/order")
public class OrderController extends BaseController {

	@Autowired
	private IOrderService orderService;

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		orderService.delete(id);
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
	public List<Order> queryCompletedOrders(HttpServletRequest request) {
		return orderService.queryCompletedOrderByUser(getSessionUser(request));
	}
}