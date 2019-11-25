package com.itmuch.feign;

import com.itmuch.entity.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @description: UserFeignClient
 * @author: ding
 * @date: 2019/11/10 10:43
 * @version: 1.0
 */

@FeignClient(name = "microservice-provider-user"/*,configuration = FeignConfiguration.class*/)
public interface UserFeignClient {

    @RequestLine("GET /{id}")
    public User findById(@Param("id") Long id);
}
