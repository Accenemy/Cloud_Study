package com.baorui.springcloud.service.impl;

import com.baorui.springcloud.dao.PaymentDao;
import com.baorui.springcloud.entities.Payment;
import com.baorui.springcloud.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Acc_Br
 * @date 2022/7/17 15:48
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;
    @Override
    public int creat(Payment payment) {
        return paymentDao.creat(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
