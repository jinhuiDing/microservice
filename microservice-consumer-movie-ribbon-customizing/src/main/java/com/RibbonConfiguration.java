package com;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: RibbonConfiguration
 * @author: ding
 * @date: 2019/11/7 23:21
 * @version: 1.0
 */
@Configuration
public class RibbonConfiguration {


    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }
}
