package com.example.springbootstarter.analizer;

import com.example.springbootstarter.exception.ConcurrencyStartupException;
import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;

public class ConcurrencyFailureAnalizer extends AbstractFailureAnalyzer<ConcurrencyStartupException> {

    @Override
    protected FailureAnalysis analyze(Throwable rootFailure, ConcurrencyStartupException cause) {
        return new FailureAnalysis(cause.getMessage(), "Укажите валидные значения для свойств", cause);
    }
}
