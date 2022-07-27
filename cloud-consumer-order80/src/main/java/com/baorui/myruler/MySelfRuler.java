package com.baorui.myruler;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Acc_Br
 * @date 2022/7/27 14:57
 */
@Configuration
public class MySelfRuler {
    @Bean
    public IRule myRuler(){
        //定义为随机
        return new RandomRule();
    }
}
