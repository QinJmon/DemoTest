package com.openbayes;

import com.openbayes.dao.UserDao;
import com.openbayes.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoTest2ApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private UserDao userDao;
	@Test
	void testFind() {
		List<User> users = userDao.findAll();
		for (User user : users) {
			System.out.println(user);
		}
	}
}
