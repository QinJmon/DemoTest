package com.openbayes.dao;

import com.openbayes.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository {

    User findByName(String name);

    Optional<User> findById(Long id);

    List<User> findAll();

    User save(User user);

    void deleteUserById(Long id);


}
