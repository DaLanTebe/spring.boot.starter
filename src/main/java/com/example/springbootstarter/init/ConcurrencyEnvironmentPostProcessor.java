package com.example.springbootstarter.init;

import com.example.springbootstarter.exception.ConcurrencyStartupException;
import org.apache.commons.logging.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.boot.logging.DeferredLogFactory;
import org.springframework.core.env.ConfigurableEnvironment;

public class ConcurrencyEnvironmentPostProcessor implements EnvironmentPostProcessor {

    private final Log log;

    public ConcurrencyEnvironmentPostProcessor(DeferredLogFactory logFactory) {
        this.log = logFactory.getLog(ConcurrencyEnvironmentPostProcessor.class);
    }
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        System.out.println("sout -> ConcurrencyEnvironmentPostProcessor");
        log.info("Вызов ConcurrencyEnvironmentPostProcessor");

        String enabledPropertyValue = environment.getProperty("concurrency.enabled");

        boolean isBoolValue = Boolean.TRUE.toString().equals(enabledPropertyValue) ||
                Boolean.FALSE.toString().equals(enabledPropertyValue);

        if (isBoolValue) {
            throw new ConcurrencyStartupException("Ошибка при проверке свойства 'concurrency.enabled'!");
        }
    }
}
