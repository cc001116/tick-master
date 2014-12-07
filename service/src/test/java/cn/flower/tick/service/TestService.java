package cn.flower.tick.service;
import java.util.Random;

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
		Random random = new Random();
		User user = new User();
		user.setUsername("user"+random.nextLong());
		user.setPassword("1234");
		userService.register(user);
		System.out.println(user.getId());
	}
	
	
	/*
	@Test
	public void querySingle() {
		//参数为你执行上一条测试时 控制台打印的ID  可测；
		User user = userService.query(6L);
		if(user == null) {
			System.out.println("对象不存在， 敢快看看数据库中有木有");
			return ;
		}
		System.out.println("用户名：" + user.getUsername()+" 时间："+user.getRegisterDate());
	}
	
	@Test
	public void update() {
		User user = userService.query(6L);
		user.setRegisterDate(new Date());
		userService.saveOrUpdate(user);
	}
	
	@Test
	public void delete() {
		userService.delete(5L);
	}*/
	
	
	
}
