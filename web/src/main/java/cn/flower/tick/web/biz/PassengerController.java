package cn.flower.tick.web.biz;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;

import cn.flower.tick.model.biz.Passenger;
import cn.flower.tick.model.enums.PassengerType;
import cn.flower.tick.service.IPassengerService;
import cn.flower.tick.web.base.BaseController;

@Controller
@RequestMapping("/passenger")
public class PassengerController extends BaseController {

	@Autowired
	private IPassengerService passengerService;

	@RequestMapping("/save")
	@ResponseBody
	public String save(HttpServletRequest request,
			@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "idCard", required = true) String idCard,
			@RequestParam(value = "phone", required = false) String phone,
			@RequestParam(value = "status", required = false) Integer status) {
		Passenger passenger = new Passenger();
		passenger.setName(name);
		passenger.setIdCard(idCard);
		passenger.setPhone(phone);
		if (status == null)
			status = PassengerType.ORDINARY.value;
		passenger.setStatus(status);
		passenger.setCreateDate(new Date());
		passenger.setCreateUser(getSessionUser(request));
		passengerService.save(passenger);
		return SUCCESS;
	}

	@RequestMapping("/view/list")
	@ResponseBody
	public String showAllPassengers(HttpServletRequest request) {
		List<Passenger> ps = passengerService.showAll(getSessionUser(request));
		SimplePropertyPreFilter filter = new SimplePropertyPreFilter(
				Passenger.class, "id", "name", "status");
		String json = JSON.toJSONString(ps, filter, new SerializerFeature[0]);
		System.out.println(json);
		return json;
	}

	@RequestMapping("/update/{id}")
	@ResponseBody
	public String update(@PathVariable Long id,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "idCard", required = false) String idCard,
			@RequestParam(value = "phone", required = false) String phone,
			@RequestParam(value = "status", required = false) int status) {
		Passenger passenger = new Passenger();
		passenger.setId(id);
		passenger.setName(name);
		passenger.setIdCard(idCard);
		passenger.setPhone(phone);
		passenger.setStatus(status);
		passengerService.update(passenger);
		return SUCCESS;
	}
}
