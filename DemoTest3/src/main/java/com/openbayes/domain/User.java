package com.openbayes.domain;

import com.openbayes.util.Util;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String name;

    private Integer age;

    private  String sex;


    public User(String name, Integer age, String sex) {
        this.name=name;
        this.age=age;
        this.sex=sex;
    }

    public void update(String name,Integer age,String sex){
        if(!Util.isEmpty(name)){
            this.name=name;
        }

        if(!Util.isEmpty(age)){
            this.age=age;
        }

        if(!Util.isEmpty(sex)){
            this.sex=sex;
        }

    }
}
