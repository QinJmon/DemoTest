package com.openbayes.fetcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.openbayes.domain.Rating;
import graphql.schema.DataFetchingEnvironment;

import java.util.Map;

@DgsComponent
public class RatingMutation {

  @DgsData(parentType = "Mutation", field = "addRating")
  public Rating addRating(DataFetchingEnvironment dataFetchingEnvironment) {
    Map<String, Object> input = dataFetchingEnvironment.getArgument("input");
    RatingInput ratingInput = new ObjectMapper().convertValue(input, RatingInput.class);

    System.out.println("Rated " + ratingInput.getTitle() + " with " + ratingInput.getStars() + " stars") ;
    return new Rating(ratingInput.getStars());

  }
}

class RatingInput {
  private String title;
  private int stars;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getStars() {
    return stars;
  }

  public void setStars(int stars) {
    this.stars = stars;
  }
}
