package com.itmuch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @description: ZuulApplication
 * @author: ding
 * @date: 2019/12/7 20:13
 * @version: 1.0
 */

@SpringBootApplication
@EnableZuulProxy
public class ZuulFallbackApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulFallbackApplication.class, args);
    }
}
