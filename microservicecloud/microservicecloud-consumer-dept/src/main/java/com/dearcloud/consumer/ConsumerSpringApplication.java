package com.dearcloud.consumer;

import com.dearcloud.consumer.config.ConfigBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "MICROSERVICECLOUD-PROVIDER-DEPT", configuration = ConfigBean.class)
public class ConsumerSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerSpringApplication.class, args);
    }
}
