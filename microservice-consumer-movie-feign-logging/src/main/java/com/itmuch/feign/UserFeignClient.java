package com.itmuch.feign;

import com.itmuch.config.FeignLogConfiguration;
import com.itmuch.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @description: UserFeignClient
 * @author: ding
 * @date: 2019/11/10 10:43
 * @version: 1.0
 */

@FeignClient(name = "microservice-provider-user")
public interface UserFeignClient {

    @RequestMapping(value = "/get0", method = RequestMethod.GET)
    public User get0(@RequestParam ("id")Long id,@RequestParam("username")String username);
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User findById(@PathVariable("id") Long id);

    @RequestMapping(value = "/get1", method = RequestMethod.GET)
    User get1(@RequestParam HashMap<String, Object> map);
    @RequestMapping(method = RequestMethod.POST,value = "post")
    public User post(@RequestBody User user);
}
