package com.dearcloud.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DeptProviderSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(DeptProviderSpringApplication.class, args);
    }
}
