package cn.flower.tick.persist;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.flower.tick.model.system.User;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:application-persist-config.xml"})
public class TestDao {
	
	@Autowired
	private IUserDao userDao;
	@Test
	public void test() {
		User entity = new User();
		entity.setUsername("nnnn");
		userDao.save(entity);
		
	}
}
