package com.dearcloud.provider1.controller;

import com.dearcloud.microservicecloud.api.domain.Dept;
import com.dearcloud.provider1.service.DeptService;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@EnableDiscoveryClient
public class DeptController {
    @Resource
    private DeptService deptService;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/dept/add")
    public boolean add(@RequestBody Dept dept) {
        return deptService.add(dept);
    }

    @GetMapping(value = "/dept/get/{id}")
    @ResponseBody
    public Dept get(@PathVariable("id") Long id) {
        return deptService.get(id);
    }

    @GetMapping(value = "/dept/list")
    @ResponseBody
    public List<Dept> list() {
        return deptService.list();
    }

    @GetMapping("/discovery")
    @ResponseBody
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        List<ServiceInstance> allInstances = new ArrayList<>();
        services.forEach(s -> {
            List<ServiceInstance> instances = discoveryClient.getInstances(s);
            allInstances.addAll(instances);
        });
        return allInstances;
    }
}

