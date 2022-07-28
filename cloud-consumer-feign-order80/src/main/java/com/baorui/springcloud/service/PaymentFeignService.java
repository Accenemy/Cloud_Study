package com.baorui.springcloud.service;

import com.baorui.springcloud.entities.CommonResult;
import com.baorui.springcloud.entities.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Acc_Br
 * @date 2022/7/28 14:59
 */
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {


   @GetMapping(value = "/payment/get/{id}")
   CommonResult<Payment>  getPaymentById(@PathVariable("id") Long id);

}
