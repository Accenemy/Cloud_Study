package com.baorui.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author Acc_Br
 * @date 2022/8/10 11:05
 */

@Component
public class PaymentFallBackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "PaymentFallBackService fall back ,--";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "PaymentFallBackService fall back ,--";

    }
}
