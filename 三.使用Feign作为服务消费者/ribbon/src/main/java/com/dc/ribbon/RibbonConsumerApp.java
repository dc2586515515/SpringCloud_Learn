package com.dc.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Description
 * @Author DC
 * @Date 2020-04-23
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class RibbonConsumerApp {

    public static void main(String[] args) {
        SpringApplication.run(RibbonConsumerApp.class, args);
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
