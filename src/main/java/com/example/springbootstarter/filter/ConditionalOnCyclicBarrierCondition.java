package com.example.springbootstarter.filter;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Conditional(ConditionalOnCyclicBarrier.class)
public @interface ConditionalOnCyclicBarrierCondition {
}
