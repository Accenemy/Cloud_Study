package com.baorui.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.security.PublicKey;

/**
 * @author Acc_Br
 * @date 2022/7/22 16:51
 */
@RestController
@Slf4j
public class OrderZkController {
    /**
     * 可以看见已经是不需要指定网址，而是直接指定Spring application name
     */
    public static final String INVOKE_URL="http://cloud-provider-payment";
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping(value = "/consumer/payment/zk")
    public String paymentInfo(){
        String result =restTemplate.getForObject(INVOKE_URL+"/payment/zk",String.class);

        return result;
    }
}
