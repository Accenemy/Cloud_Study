package com.baorui.springcloud.alibaba.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.baorui.springcloud.entities.CommonResult;

/**
 * @author Acc_Br
 * @date 2022/10/6 9:39
 */
public class CustomerBlockHandler {
    public static CommonResult handlerException(BlockException exception){
        return  new CommonResult(444,"自定义异常，global handlerException-->1");

    }

    public static CommonResult handlerException2(BlockException exception){
        return  new CommonResult(444,"自定义异常，global handlerException-->2");

    }
}
