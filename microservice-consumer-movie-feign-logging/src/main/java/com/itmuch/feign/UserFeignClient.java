package com.itmuch.feign;

import com.itmuch.config.FeignLogConfiguration;
import com.itmuch.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @description: UserFeignClient
 * @author: ding
 * @date: 2019/11/10 10:43
 * @version: 1.0
 */

@FeignClient(name = "microservice-provider-user")
public interface UserFeignClient {

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User findById(@PathVariable("id") Long id);
}
