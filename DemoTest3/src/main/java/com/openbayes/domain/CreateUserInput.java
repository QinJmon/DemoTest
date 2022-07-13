package com.openbayes.domain;

import lombok.Data;

@Data
public class CreateUserInput {
    private String name;
    private Integer age;
    private String sex;
}
