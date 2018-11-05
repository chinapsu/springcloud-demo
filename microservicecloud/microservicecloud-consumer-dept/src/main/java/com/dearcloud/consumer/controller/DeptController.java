package com.dearcloud.consumer.controller;

import com.dearcloud.microservicecloud.api.domain.Dept;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class DeptController {
    private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-PROVIDER-DEPT";
    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/dept/add")
    public boolean add(@RequestBody Dept dept) {
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
    }

    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
    }

    @GetMapping("/dept/list")
    public List list() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
    }
}
