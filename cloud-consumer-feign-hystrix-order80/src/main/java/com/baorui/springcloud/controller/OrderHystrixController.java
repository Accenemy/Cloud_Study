package com.baorui.springcloud.controller;

import com.baorui.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Acc_Br
 * @date 2022/8/9 10:31
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallBackMethod")
public class OrderHystrixController {


    @Autowired
    private PaymentHystrixService paymentHystrixService;


    @GetMapping("/comsumer/payment/hystrix/ok{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
            String result =paymentHystrixService.paymentInfo_OK(id);
            return result;
    }


    //超过3秒自动调用“兜底方法”
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    })
    @GetMapping("/comsumer/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        String result =paymentHystrixService.paymentInfo_TimeOut(id);
        return result;
    }

    public String paymentInfo_TimeOutHandler(Integer id ){

        return "我是消费者80，对方支付系统繁忙请10秒钟后再试！";
    }

    //全局FallBack
    public String payment_Global_FallBackMethod(){
        return "Global 异常处理信息，请稍后重试！";
    }
}
