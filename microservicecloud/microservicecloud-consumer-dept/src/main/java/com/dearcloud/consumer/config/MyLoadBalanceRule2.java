package com.dearcloud.consumer.config;

import com.netflix.loadbalancer.ClientConfigEnabledRoundRobinRule;
import com.netflix.loadbalancer.Server;

/**继承自ClientConfigEnabledRoundRobinRule，则默认就是轮休。*/
public class MyLoadBalanceRule2 extends ClientConfigEnabledRoundRobinRule {

    @Override
    public Server choose(Object key) {

        return super.choose(key); //父级是轮休
    }
}
