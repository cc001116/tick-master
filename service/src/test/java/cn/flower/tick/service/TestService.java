package cn.flower.tick.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.flower.tick.model.system.User;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-service-config.xml")
public class TestService {
	
	@Autowired
	private IUserService userService;

	@Test
	public void register() {
		User user = new User();
		user.setUsername("ssssssss");
		userService.register(user);
	}
	
}
