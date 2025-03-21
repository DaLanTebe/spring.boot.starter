package com.example.springbootstarter.configuration;

import com.example.springbootstarter.Bean.BarrierAction;
import com.example.springbootstarter.Bean.BarrierActionImpl;
import com.example.springbootstarter.aspect.LockAspect;
import com.example.springbootstarter.aspect.UseCyclicBarrierAspect;
import com.example.springbootstarter.aspect.UseSemaphoreAspect;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@EnableConfigurationProperties(ConfigurationProperties.class)
public class ConcurrencyAutoConfiguration {

    @Bean
    public BarrierAction  barrierAction(){
        return new BarrierActionImpl();
    }

    @Bean
    public LockAspect lockAspect(){
        return new LockAspect();
    }

    @Bean
    public UseCyclicBarrierAspect useCyclicBarrierAspect(BarrierAction barrierAction){
        return new UseCyclicBarrierAspect(barrierAction);
    }

    @Bean
    public UseSemaphoreAspect useSemaphoreAspect(){
        return new UseSemaphoreAspect();
    }
}
