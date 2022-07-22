package com.openbayes.fetcher;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsSubscription;
import reactor.core.publisher.Flux;

import java.time.Duration;

@DgsComponent
public class SubscriptionDataFetcher {

    @DgsSubscription
    public Publisher<Stock> stocks(){
        return Flux.interval(Duration.ofSeconds(0),Duration.ofSeconds(1)).map(t->new Stock("NFLX",500+t));
    }
}
