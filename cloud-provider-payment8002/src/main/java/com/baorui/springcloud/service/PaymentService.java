package com.baorui.springcloud.service;

import com.baorui.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author Acc_Br
 * @date 2022/7/17 15:47
 */
public interface PaymentService {

    int creat(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
