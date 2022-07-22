package com.openbayes.dao;

import com.openbayes.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User,Long>, JpaSpecificationExecutor<User> {

    //根据id修改名字
    @Query("update from User set Name=?2 where id=?1")
    @Modifying
    void updateNameById(Long id,String name);
}
