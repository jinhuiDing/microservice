package com.itmuch.controller;

import com.itmuch.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @description: UserController
 * @author: ding
 * @date: 2019/11/5 20:08
 * @version: 1.0
 */


@RestController
public class MovieController {

    private Logger logger = LoggerFactory.getLogger(MovieController.class);
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;


    @Value("${user.userServiceUrl}")
    private String url;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id){
//        ServiceInstance choose = loadBalancerClient.choose("microservice-provider-user");
//        logger.info("{}:{}:{}",choose.getServiceId(),choose.getHost(),choose.getPort());
        return restTemplate.getForObject("http://microservice-provider-user/" + id, User.class);
    }

    @GetMapping("log-user-instance")
    public void logUserInstance() {
        ServiceInstance choose = this.loadBalancerClient.choose("microservice-provider-user");
        logger.info("{}:{}:{}",choose.getServiceId(),choose.getHost(),choose.getPort());
    }
}
