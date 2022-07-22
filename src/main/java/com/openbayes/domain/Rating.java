package com.openbayes.domain;

import lombok.Data;

@Data
public class Rating {
    private Float avgStars;

    private  String  title;

    private Integer stars;

    public Rating(Integer stars) {
        this.stars = stars;
    }
}
