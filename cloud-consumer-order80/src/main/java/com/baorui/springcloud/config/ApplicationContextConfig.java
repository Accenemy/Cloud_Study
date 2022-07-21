package com.baorui.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Acc_Br
 * @date 2022/7/18 10:00
 */
@Configuration
public class ApplicationContextConfig {
    //定义restTemplate负载均衡的功能
    @Bean
    @LoadBalanced
    public RestTemplate getResultTemplate(){
        return new RestTemplate();
    }
}
