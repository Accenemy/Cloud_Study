package com.baorui.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author Acc_Br
 * @date 2022/8/8 10:28
 */
@Service
public class PaymentService {

    public String paymentInfo_OK(Integer id){
        return "线程池："+Thread.currentThread().getName()+"paymentInfo_OK"+id+"\t"+"----";

    }

    //超过3秒自动调用“兜底方法”
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentInfo_TimeOut(Integer id){


        int timeNumber =3;
        try{
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+"paymentInfo_TimeOut"+id+"\t"+"----"+"耗时"+timeNumber+"秒";

    }
    public String paymentInfo_TimeOutHandler(Integer id ){

        return "线程池："+Thread.currentThread().getName()+"paymentInfo_TimeOutHandler"+id+"\t"+"----OvO系统繁忙，请稍后再试";
    }


}
