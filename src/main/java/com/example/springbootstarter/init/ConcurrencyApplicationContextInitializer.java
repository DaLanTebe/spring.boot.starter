package com.example.springbootstarter.init;

import com.example.springbootstarter.Bean.ThreadsInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class ConcurrencyApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

   private static final Logger log = LoggerFactory.getLogger(ConcurrencyApplicationContextInitializer.class);

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        log.info("Вызов ConcurrencyApplicationContextInitializer");

        applicationContext.getBeanFactory().registerSingleton(ThreadsInfo.class.getSimpleName(), new ThreadsInfo());
    }
}
