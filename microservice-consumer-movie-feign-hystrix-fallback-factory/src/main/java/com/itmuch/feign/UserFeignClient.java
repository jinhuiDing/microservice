package com.itmuch.feign;

import com.itmuch.entity.User;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @description: UserFeignClient
 * @author: ding
 * @date: 2019/11/10 10:43
 * @version: 1.0
 */

@FeignClient(name = "microservice-provider-user", fallbackFactory = UserFeignClient.UserFeignClientFallbackFactory.class)
public interface UserFeignClient {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable("id") Long id);

    @Component
    class UserFeignClientFallbackFactory implements FallbackFactory<UserFeignClient> {


        @Override
        public UserFeignClient create(Throwable throwable) {
            Logger log = LoggerFactory.getLogger(UserFeignClientFallbackFactory.class);
            log.warn(throwable.getMessage());
            throwable.printStackTrace();
            return new UserFeignClient() {
                @Override
                public User findById(Long id) {
                    User user = new User();
                    user.setUsername("丁锦辉");
                    user.setAge(12);
                    user.setId(-1L);
                    return user;
                }
            };
        }
    }
}
