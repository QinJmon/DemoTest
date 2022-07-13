package com.openbayes.dao;

import com.openbayes.domain.User;
import com.openbayes.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
@RequiredArgsConstructor
public class JpaUserRepository implements UserRepository{

    private final UserMapper userMapper;

    @Override
    public User findByName(String name) {
        return userMapper.findByName(name);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userMapper.findById(String.valueOf(id));
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public User save(User user) {
       return userMapper.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
         userMapper.deleteById(String.valueOf(id));
    }


}
