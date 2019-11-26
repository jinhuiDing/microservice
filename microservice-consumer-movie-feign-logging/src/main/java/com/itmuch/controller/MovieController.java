package com.itmuch.controller;

import com.itmuch.entity.User;
import com.itmuch.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

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
    UserFeignClient userFeignClient;
    @Value("${user.userServiceUrl}")
    private String url;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id){
        return userFeignClient.findById(id);
//        return restTemplate.getForObject(url + id, User.class);
    }

    @GetMapping("get0")
    public User get0(){
        return this.userFeignClient.get0(1L,"张三");
    } @GetMapping("get1/{id}")
    public User get1(@PathVariable Long id){
        HashMap<String, Object> map = new HashMap<>();
        map.put("id",id);
        return this.userFeignClient.get1(map);
    }

    @RequestMapping(method = RequestMethod.POST,value = "post")
    public User post(@RequestBody User user){
        return this.userFeignClient.post(user);
    }
}
