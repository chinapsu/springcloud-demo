package com.dearcloud.consumer.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.Random;

public class MyLoadBalanceRule extends AbstractLoadBalancerRule {
    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {
    }

    private Random random = new Random();

    @Override
    public Server choose(Object o) {
        List<Server> allServers = this.getLoadBalancer().getAllServers();
        List<Server> upServers = this.getLoadBalancer().getReachableServers();
        if (upServers.size() > 0) {
            int idx = random.nextInt(upServers.size());
            return upServers.get(idx);
        }
        return null;
    }
}
