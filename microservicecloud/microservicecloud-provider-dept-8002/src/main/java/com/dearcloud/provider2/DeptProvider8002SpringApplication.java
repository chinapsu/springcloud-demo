package com.dearcloud.provider2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DeptProvider8002SpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8002SpringApplication.class, args);
    }
}
