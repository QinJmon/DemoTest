package com.openbayes;

import com.netflix.graphql.dgs.DgsQueryExecutor;
import com.netflix.graphql.dgs.autoconfig.DgsAutoConfiguration;
import com.openbayes.fetcher.RatingMutation;
import com.openbayes.fetcher.ShowsDatafetcher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {DgsAutoConfiguration.class, RatingMutation.class})
public class RatingMutationTest {

    @Autowired
    DgsQueryExecutor dgsQueryExecutor;

  @Test
  void testRatingMutation() {

  }
}
