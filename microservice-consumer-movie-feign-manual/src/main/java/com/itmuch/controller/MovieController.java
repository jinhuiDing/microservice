package com.itmuch.controller;

import com.itmuch.entity.User;
import com.itmuch.feign.UserFeignClient;
import feign.Client;
import feign.Contract;
import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.feign.FeignClientsConfiguration;
import org.springframework.context.annotation.Import;
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

@Import(FeignClientsConfiguration.class)

@RestController
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;


    UserFeignClient userFeignClient;

    UserFeignClient adminUserFeignClient;


    @Autowired
    public MovieController(Decoder decoder, Encoder encoder, Client client, Contract contract) {
        this.userFeignClient = Feign.builder().client(client).encoder(encoder).decoder(decoder).contract(contract)
                .requestInterceptor(new BasicAuthRequestInterceptor("user", "passwd1"))
                .target(UserFeignClient.class, "http://microservice-provider-user/");
        this.adminUserFeignClient = Feign.builder().client(client).encoder(encoder).
                decoder(decoder).contract(contract)
                .requestInterceptor(new BasicAuthRequestInterceptor("admin", "passwd2"))
                .target(UserFeignClient.class, "http://microservice-provider-user/");

    }

    @Value("${user.userServiceUrl}")
    private String url;

    @GetMapping("/user-user/{id}")
    public User findById(@PathVariable Long id) {
        return userFeignClient.findById(id);
//        return restTemplate.getForObject(url + id, User.class);
    }


    @GetMapping("user-admin/{id}")
    public User findByIdAdmin(@PathVariable Long id) {
        return adminUserFeignClient.findById(id);
    }
}
