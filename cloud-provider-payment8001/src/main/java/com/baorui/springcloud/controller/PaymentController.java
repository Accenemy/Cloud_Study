package com.baorui.springcloud.controller;

import com.baorui.springcloud.entities.CommonResult;
import com.baorui.springcloud.entities.Payment;
import com.baorui.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Acc_Br
 * @date 2022/7/17 15:49
 */
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult creat(Payment payment){
        int result = paymentService.creat(payment);
        log.info("插入结果：{}",result);
        if (result>0){
            return new CommonResult(200,"插入数据成功",result);

        }
            return new CommonResult(500,"插入数据失败",null);
    }


    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment paymentById = paymentService.getPaymentById(id);
        log.info("查询结果：{}",paymentById);
        if (paymentById!=null){
            return new CommonResult(200,"查询数据成功",paymentById);
        }
        return new CommonResult(500,"没有对应记录，查询ID:"+id,null);
    }


}
