package com.itmuch.feign;

import com.itmuch.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.math.BigDecimal;

/**
 * @description: UserFeignClient
 * @author: ding
 * @date: 2019/11/10 10:43
 * @version: 1.0
 */

@FeignClient(name = "microservice-provider-user", fallback = UserFeignClient.UserFeignClientFallback.class)
public interface UserFeignClient {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable("id") Long id);

    @Component
    class UserFeignClientFallback implements UserFeignClient {
        @Override
        public User findById(Long id) {
            User user = new User();
            user.setAge(23);
            user.setBalance(BigDecimal.valueOf(1.2));
            user.setName("默认用户");
            user.setUsername("默认用户userName");

            return user;
        }
    }
}
