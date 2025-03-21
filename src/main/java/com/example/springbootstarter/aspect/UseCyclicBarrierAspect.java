package com.example.springbootstarter.aspect;

import com.example.springbootstarter.Bean.BarrierAction;
import com.example.springbootstarter.annotation.UseCyclicBarrier;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;

@Aspect
public class UseCyclicBarrierAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(UseCyclicBarrierAspect.class);

    private final Map<String, CyclicBarrier> barriers = new ConcurrentHashMap<>();

    private final BarrierAction barrierAction;

    public UseCyclicBarrierAspect(BarrierAction barrierAction) {
        this.barrierAction = barrierAction;
    }

    @Pointcut("@annotation(useCyclicBarrier)")
    public void useCyclicBarrierPointcut(UseCyclicBarrier useCyclicBarrier){}

    @Before("useCyclicBarrierPointcut(useCyclicBarrier)")
    public void beforeUseCyclicBarrier(UseCyclicBarrier useCyclicBarrier){
        String barrierName = useCyclicBarrier.barrier();

        CyclicBarrier barrier = barriers.computeIfAbsent(barrierName, k -> new CyclicBarrier(useCyclicBarrier.parties(), barrierAction::action));

        try {
            LOGGER.info("Поток " + Thread.currentThread().threadId() + " ждет у барьера");

            barrier.await();

            LOGGER.info("Поток " + Thread.currentThread().threadId() + " Пересек барьер");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
