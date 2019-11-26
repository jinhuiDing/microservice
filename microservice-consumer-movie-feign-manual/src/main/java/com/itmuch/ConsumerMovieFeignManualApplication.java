package com.itmuch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @description: ProviderUserApplication
 * @author: ding
 * @date: 2019/11/5 20:09
 * @version: 1.0
 */

@SpringBootApplication
public class ConsumerMovieFeignManualApplication {



    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
    public static void main(String[] args) {
        SpringApplication.run(ConsumerMovieFeignManualApplication.class, args);
    }
}
