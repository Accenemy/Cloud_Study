package com.baorui.springcloud.dao;

import com.baorui.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Acc_Br
 * @date 2022/7/17 14:40
 */
@Mapper
public interface PaymentDao {

    int creat(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
