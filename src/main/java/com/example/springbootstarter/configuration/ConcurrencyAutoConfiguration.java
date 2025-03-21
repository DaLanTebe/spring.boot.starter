package com.example.springbootstarter.configuration;

import com.example.springbootstarter.Bean.BarrierAction;
import com.example.springbootstarter.Bean.BarrierActionImpl;
import com.example.springbootstarter.aspect.LockAspect;
import com.example.springbootstarter.aspect.UseCyclicBarrierAspect;
import com.example.springbootstarter.aspect.UseSemaphoreAspect;
import com.example.springbootstarter.configuration.properties.ConcurrencyProperties;
import com.example.springbootstarter.filter.ConditionalOnCyclicBarrierCondition;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@EnableConfigurationProperties(ConcurrencyProperties.class)
@ConditionalOnProperty(prefix = "concurrency", value = "enabled", havingValue = "true", matchIfMissing = false)
public class ConcurrencyAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public BarrierAction  barrierAction(){
        return new BarrierActionImpl();
    }

    @Bean
    @ConditionalOnExpression("${concurrency.lock:false}")
    public LockAspect lockAspect(){
        return new LockAspect();
    }

    @Bean
    @ConditionalOnCyclicBarrierCondition
    public UseCyclicBarrierAspect useCyclicBarrierAspect(BarrierAction barrierAction){
        return new UseCyclicBarrierAspect(barrierAction);
    }

    @Bean
    @ConditionalOnProperty(prefix = "concurrency", value = "semaphore-enabled", havingValue = "true", matchIfMissing = true)
    public UseSemaphoreAspect useSemaphoreAspect(){
        return new UseSemaphoreAspect();
    }
}
