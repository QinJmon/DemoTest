package com.openbayes.mapper;

import com.openbayes.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserMapper extends JpaRepository<User, String> {

    @Query("from User where name=?1")
    User findByName(String name);

   /* @Query("from User where id=?1")
    Optional<User> findById(Long id);*/
}
