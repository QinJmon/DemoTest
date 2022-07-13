package com.openbayes.fetcher;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import com.openbayes.dao.UserRepository;
import com.openbayes.domain.CreateUserInput;
import com.openbayes.domain.DeletionStatus;
import com.openbayes.domain.UpdateUserInput;
import com.openbayes.domain.User;
import com.openbayes.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
/*import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;*/

import java.util.List;
import java.util.Optional;

@DgsComponent
@RequiredArgsConstructor
public class UserDatafetcher {

   private final UserRepository userRepository;

   private final UserMapper userMapper;


    @DgsQuery
    public User findByName(@InputArgument String name){
        return userRepository.findByName(name);
    }

    @DgsQuery
    public User findByName2(@InputArgument String name){
        return userMapper.findByName(name);
    }

    @DgsData(parentType = "Query",field = "users")
    public List<User> users(){
        return userMapper.findAll();
    }

    @DgsData(parentType = "Mutation",field = "createUser")
    public User createUser(@InputArgument("input") CreateUserInput input){
        User user=new User(input.getName(),input.getAge(),input.getSex());
       return  userRepository.save(user);
    }

  /*  @DgsData(parentType = "Mutation",field = "updateUser")
    public User updateUser(@InputArgument("changes") UpdateUserInput updateUserInput){
        //获取当前登录用户
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken
                || authentication.getPrincipal() == null) {
            return null;
        }

        User currentUser = (User) authentication.getPrincipal();
        //修改当前用户的属性值
        currentUser.update(updateUserInput.getName(), updateUserInput.getAge(),updateUserInput.getSex());
        //保存当前用户
       return userRepository.save(currentUser);
    }*/

    //根据名字修改年龄
    @DgsData(parentType = "Mutation",field = "updateAgeByName")
    public User updateAgeByName(@InputArgument("name")String name,@InputArgument("age")Integer age){
        User user = userRepository.findByName(name);
        user.setAge(age);
        return userRepository.save(user);

    }

    //根据id删除用户
    @DgsData(parentType = "Mutation",field = "deleteUser")
    public DeletionStatus deleteUser(@InputArgument("id")String id){
        //先判断用户是否存在
        Optional<User> user = userRepository.findById(Long.valueOf(id));
        if(user==null){
            throw new RuntimeException("user is not exist!");
        }
        userRepository.deleteUserById(Long.valueOf(id));
        return DeletionStatus.newBuilder().success(true).build();
    }


}
