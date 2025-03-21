package com.example.springbootstarter.configuration.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "concurrency")
public class ConcurrencyProperties {

    private Boolean enabled;

    private Boolean lockEnabled;

    private Boolean cyclicBarrierEnabled;

    private Boolean semaphoreEnabled;

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public void setLockEnabled(Boolean lockEnabled) {
        this.lockEnabled = lockEnabled;
    }

    public void setCyclicBarrierEnabled(Boolean cyclicBarrierEnabled) {
        this.cyclicBarrierEnabled = cyclicBarrierEnabled;
    }

    public void setSemaphoreEnabled(Boolean semaphoreEnabled) {
        this.semaphoreEnabled = semaphoreEnabled;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public Boolean getLockEnabled() {
        return lockEnabled;
    }

    public Boolean getCyclicBarrierEnabled() {
        return cyclicBarrierEnabled;
    }

    public Boolean getSemaphoreEnabled() {
        return semaphoreEnabled;
    }
}
