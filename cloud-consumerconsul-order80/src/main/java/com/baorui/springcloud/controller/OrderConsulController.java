package com.baorui.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Acc_Br
 * @date 2022/7/23 14:05
 */
@RestController
@Slf4j
public class OrderConsulController {
    /**
     * 可以看见已经是不需要指定网址，而是直接指定Spring application name
     */
    public static final String INVOKE_URL="http://consul-provider-payment";
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping(value = "/consumer/payment/consul")
    public String paymentInfo(){
        String result =restTemplate.getForObject(INVOKE_URL+"/payment/consul",String.class);

        return result;
    }
}
