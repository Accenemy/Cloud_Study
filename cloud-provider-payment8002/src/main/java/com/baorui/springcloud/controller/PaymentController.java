package com.baorui.springcloud.controller;

import com.baorui.springcloud.entities.CommonResult;
import com.baorui.springcloud.entities.Payment;
import com.baorui.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Acc_Br
 * @date 2022/7/17 15:49
 */
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult creat(@RequestBody Payment payment){
        int result = paymentService.creat(payment);
        log.info("插入结果：{}",result);
        if (result>0){
            return new CommonResult(200,"插入数据成功,serverPort:"+serverPort,result);

        }
            return new CommonResult(500,"插入数据失败",null);
    }


    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment paymentById = paymentService.getPaymentById(id);
        log.info("查询结果：{}",paymentById);
        if (paymentById!=null){
            return new CommonResult(200,"查询数据成功,serverPort:"+serverPort,paymentById);
        }
        return new CommonResult(500,"没有对应记录，查询ID:"+id,null);
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();


        for (String element:services){
            log.info("element:{}",element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE\t");
        for (ServiceInstance instance:instances){
            log.info("instance:{}",instance.toString());
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }
}
