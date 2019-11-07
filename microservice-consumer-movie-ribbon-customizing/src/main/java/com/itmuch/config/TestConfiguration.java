package com.itmuch.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

/**
 * @description: TestConfiguration
 * @author: ding
 * @date: 2019/11/7 23:24
 * @version: 1.0
 */

@Configuration
@RibbonClient(name ="microservice-provider-user",configuration = RibbonConfiguration.class)
public class TestConfiguration {
}
