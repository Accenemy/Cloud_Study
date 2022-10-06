package com.baorui.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.baorui.springcloud.alibaba.myhandler.CustomerBlockHandler;
import com.baorui.springcloud.entities.CommonResult;
import com.baorui.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Acc_Br
 * @date 2022/10/5 23:46
 */
@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public CommonResult byResource(){
        return  new CommonResult(200,"按资源名称限流测试OK",new Payment(2022L,"serial001"));
    }

    public CommonResult handleException(BlockException exception){
        return new CommonResult(444,exception.getClass().getCanonicalName()+"\t服务不可用t");
    }


    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",blockHandler = "handleException",blockHandlerClass = CustomerBlockHandler.class)
    public CommonResult customerBlockHandler(){
        return  new CommonResult(200,"用户自定义",new Payment(2022L,"serial003"));
    }
}
