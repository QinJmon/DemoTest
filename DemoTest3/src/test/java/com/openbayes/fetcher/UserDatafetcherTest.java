package com.openbayes.fetcher;

import com.netflix.graphql.dgs.DgsQueryExecutor;
import com.openbayes.dao.UserRepository;
import com.openbayes.domain.User;
import com.openbayes.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import java.util.List;

@SpringBootTest
public class UserDatafetcherTest {

  @Autowired private UserMapper userMapper;

  @Autowired DgsQueryExecutor dgsQueryExecutor;

  /*@BeforeEach
  public void  setUp(){
       User user1=new User("1","kk",12,"man");
       User user2=new User("2","qq",11,"man");
       User user3=new User("3","ww",13,"man");
       User user4=new User("4","ee",15,"man");
        users=
               new ArrayList<>(){
                   {
                       add(user1);
                       add(user2);
                       add(user3);
                       add(user4);
                   }
       };
   }*/

  @Test
  void findByName() {}

  @Test
  void users() {
    List<User> users = userMapper.findAll();
    List<User> result =
        dgsQueryExecutor.executeAndExtractJsonPath(
            "query{\n" + "    users{\n" + "        name\n" + "    }\n" + "}", "data.users[*]");

    assertThat(users.size(), is(result.size()));
  }
}
