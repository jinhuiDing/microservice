package com.itmuch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @description: ProviderUserApplication
 * @author: ding
 * @date: 2019/11/5 20:09
 * @version: 1.0
 */

@SpringBootApplication
@EnableEurekaClient
public class ConsumerMovieRibbonCustomApplication {



    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
    public static void main(String[] args) {
        SpringApplication.run(ConsumerMovieRibbonCustomApplication.class, args);
    }
}
