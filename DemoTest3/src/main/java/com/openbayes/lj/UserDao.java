package com.openbayes.lj;

import com.openbayes.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface UserDao extends JpaRepository<User,Long>, JpaSpecificationExecutor<User> {

    //根据名字找用户
  /*  @Query("from User where Name=?")
    Optional<User> findByName(String name);
    //根据id修改名字
    @Query("update from User set Name=?2 where id=?1")
    @Modifying
    void updateNameById(Long id,String name);*/
}
