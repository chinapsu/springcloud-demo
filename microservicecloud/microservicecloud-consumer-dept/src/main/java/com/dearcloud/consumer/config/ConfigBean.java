package com.dearcloud.consumer.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public IRule getRule() {
        //return new com.netflix.loadbalancer.RoundRobinRule();
        //return new com.netflix.loadbalancer.RandomRule();
        //return new com.netflix.loadbalancer.BestAvailableRule();
        return new com.netflix.loadbalancer.RetryRule(new RoundRobinRule(), 30000);
        //return new MyLoadBalanceRule();
        //Ribbon本身提供了下面几种负载均衡策略：
        //RoundRobinRule: 轮询策略，Ribbon以轮询的方式选择服务器，这个是默认值。所以示例中所启动的两个服务会被循环访问;
        //RandomRule: 随机选择，也就是说Ribbon会随机从服务器列表中选择一个进行访问;
        //BestAvailableRule: 最大可用策略，即先过滤出故障服务器后，选择一个当前并发请求数最小的;
        //WeightedResponseTimeRule: 带有加权的轮询策略，对各个服务器响应时间进行加权处理，然后在采用轮询的方式来获取相应的服务器;
        //AvailabilityFilteringRule: 可用过滤策略，先过滤出故障的或并发请求大于阈值一部分服务实例，然后再以线性轮询的方式从过滤后的实例清单中选出一个;
        //ZoneAvoidanceRule: 区域感知策略，先使用主过滤条件（区域负载器，选择最优区域）对所有实例过滤并返回过滤后的实例清单，依次使用次过滤条件列表中的过滤条件对主过滤条件的结果进行过滤，判断最小过滤数（默认1）和最小过滤百分比（默认0），最后对满足条件的服务器则使用RoundRobinRule(轮询方式)选择一个服务器实例。
        //参考链接：https://www.jianshu.com/p/df9393755a05
    }
}
