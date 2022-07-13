package com.openbayes;

import com.openbayes.dao.UserRepository;
import com.openbayes.lj.UserDao;
import com.openbayes.domain.User;
import com.openbayes.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class JPATest {

    @Autowired
    private UserMapper userMapper;

   /* @Autowired
    private UserRepository userRepository;*/

  @Test
  void testFindAll() {
     // List<User> users = userRepository.findAll();
      List<User> users = userMapper.findAll();
      for (User user : users) {
      System.out.println(user);
    }
  }
}
