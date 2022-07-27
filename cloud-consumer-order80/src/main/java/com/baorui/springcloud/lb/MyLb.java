package com.baorui.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Acc_Br
 * @date 2022/7/27 15:53
 */
@Component
public class MyLb implements LoadBalancer{



    private AtomicInteger atomicInteger=new AtomicInteger(0);

    /**
     * 自旋锁
     * 何谓自旋锁？它是为实现保护共享资源而提出一种锁机制。其实，自旋锁与互斥锁比较类似，它们都是为了解决对某项资源的互斥使用。
     * 无论是互斥锁，还是自旋锁，在任何时刻，最多只能有一个保持者，也就说，在任何时刻最多只能有一个执行单元获得锁。但是两者在调度机制上略有不同。对于互斥锁，如果资源已经被占用，
     * 资源申请者只能进入睡眠状态。但是自旋锁不会引起调用者睡眠，如果自旋锁已经被别的执行单元保持，调用者就一直循环在那里看是否该自旋锁的保持者已经释放了锁，"自旋"一词就是因此而得名。
     * @return
     */
    public final int getAndIncrement(){
        int current;
        int next;
        do {
            current=this.atomicInteger.get();
            next = current>=Integer.MAX_VALUE ? 0:current+1;

        }
        while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("*****第几次访问，次数next:"+next);
        return next;
    }
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();



        return serviceInstances.get(index);
    }
}
