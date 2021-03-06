package com.itmuch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @description: ProviderUserApplication
 * @author: ding
 * @date: 2019/11/5 20:09
 * @version: 1.0
 */

@SpringBootApplication
@EnableFeignClients
public class ConsumerMovieLoggingFeignApplication {



    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
    public static void main(String[] args) {
        SpringApplication.run(ConsumerMovieLoggingFeignApplication.class, args);
    }
}
