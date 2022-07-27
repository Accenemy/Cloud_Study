package com.baorui.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author Acc_Br
 * @date 2022/7/27 15:50
 */
public interface LoadBalancer {

    /**
     * 获取Eureka上存活的服务
     * @param serviceInstances 服务
     * @return 返回服务
     */
    ServiceInstance instances(List<ServiceInstance> serviceInstances);


}
