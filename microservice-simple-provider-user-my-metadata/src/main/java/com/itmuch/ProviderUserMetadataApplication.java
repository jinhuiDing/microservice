package com.itmuch;

import com.netflix.discovery.DiscoveryClient;
import com.sun.jersey.api.client.filter.ClientFilter;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

/**
 * @description: ProviderUserApplication
 * @author: ding
 * @date: 2019/11/5 20:09
 * @version: 1.0
 */

@SpringBootApplication
public class ProviderUserMetadataApplication {

    @Bean
    public DiscoveryClient.DiscoveryClientOptionalArgs discoveryClientOptionalArgs() {
        DiscoveryClient.DiscoveryClientOptionalArgs client = new DiscoveryClient.DiscoveryClientOptionalArgs();
        ArrayList<ClientFilter> list = new ArrayList<ClientFilter>();
        list.add(new HTTPBasicAuthFilter("user", "password123"));
        client.setAdditionalFilters(list);
        return client;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProviderUserMetadataApplication.class, args);
    }
}
