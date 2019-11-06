package com.itmuch.controller;


import com.itmuch.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @description: UserController
 * @author: ding
 * @date: 2019/11/5 20:08
 * @version: 1.0
 */


@RestController
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    DiscoveryClient discoveryClient;

    @Value("${user.userServiceUrl}")
    private String url;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        return restTemplate.getForObject(url + id, User.class);
    }

    @GetMapping("/user-instance")
    public List<ServiceInstance> showInfo() {
        List<ServiceInstance> instances = this.discoveryClient.getInstances("microservice-provider-user");
        return instances;
    }
}
