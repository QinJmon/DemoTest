package com.openbayes.fetcher;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import com.openbayes.dao.UserDao;
import com.openbayes.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@DgsComponent
@AllArgsConstructor
public class UserDatafetcher {

   /* @Autowired
    private UserDao userDao;*/

    private final List<User> users=List.of(
            new User("1","kkk","nv",13),
            new User("2","qqq","nv",12),
            new User("3","aaa","nv",11)
    );


    @DgsQuery
    public List<User> users(){
        return users;
    }


}


