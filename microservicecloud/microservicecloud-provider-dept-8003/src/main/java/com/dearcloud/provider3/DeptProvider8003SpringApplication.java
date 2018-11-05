package com.dearcloud.provider3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DeptProvider8003SpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8003SpringApplication.class, args);
    }
}
