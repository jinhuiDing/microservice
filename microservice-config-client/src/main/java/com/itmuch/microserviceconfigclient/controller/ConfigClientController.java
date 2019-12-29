package com.itmuch.microserviceconfigclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: ConfigClientController
 * @author: ding
 * @date: 2019/12/29 19:28
 * @version: 1.0
 */

@RestController
public class ConfigClientController {

    @Value("${profile}")
    private String profile;


    @GetMapping("/profile")
    public String hello() {
        return this.profile;
    }
}
