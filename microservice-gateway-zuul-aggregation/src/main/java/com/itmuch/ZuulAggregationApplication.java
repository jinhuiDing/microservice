package com.itmuch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @description: ZuulApplication
 * @author: ding
 * @date: 2019/12/7 20:13
 * @version: 1.0
 */

@SpringBootApplication
@EnableZuulProxy
public class ZuulAggregationApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulAggregationApplication.class, args);


    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
