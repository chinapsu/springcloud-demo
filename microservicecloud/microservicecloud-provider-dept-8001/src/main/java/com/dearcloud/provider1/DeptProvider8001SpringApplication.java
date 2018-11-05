package com.dearcloud.provider1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DeptProvider8001SpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8001SpringApplication.class, args);
    }
}
