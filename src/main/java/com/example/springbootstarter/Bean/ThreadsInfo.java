package com.example.springbootstarter.Bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class ThreadsInfo {

    private static final Logger logger = LoggerFactory.getLogger(ThreadsInfo.class);

    private final ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

    public void printThreadsInfo() {
        ThreadInfo[] allThreads = threadMXBean.dumpAllThreads(true, true);

        for (ThreadInfo threadInfo : allThreads) {
            logger.info("Имя потока: " + threadInfo.getThreadName());
            logger.info("ID потока: " + threadInfo.getThreadId());
            logger.info("Статус потока: " + threadInfo.getThreadState());
            logger.info("---------------------------");

        }
    }
}
