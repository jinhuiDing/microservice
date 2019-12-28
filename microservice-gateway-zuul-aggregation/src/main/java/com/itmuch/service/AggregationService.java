package com.itmuch.service;

import com.itmuch.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rx.Observable;

/**
 * @description: AggregationService
 * @author: ding
 * @date: 2019/12/15 10:05
 * @version: 1.0
 */

@Service
public class AggregationService {

    @Autowired
    private RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "fallback")
    public Observable<User> getUserById(Long id) {

        return Observable.create(observable->{
            User user = restTemplate.getForObject("http://microservice-provider-user/{id}", User.class, id);
            observable.onNext(user);
            observable.onCompleted();
        });

    }

    @HystrixCommand(fallbackMethod = "fallback")
    public Observable<User> getMovieUserByUserId(Long id) {
        return Observable.create(observer->{
            User user = restTemplate.getForObject("http://microservice-simple-consumer-movie/user/{id}", User.class, id);
            observer.onNext(user);
            observer.onCompleted();
        });
    }

    public User fallback(Long id){
        User user = new User();
        user.setId(-1L);
        return user;
    }
}
