package com.tirmizee.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class TestService {

    public static final Logger logger = LoggerFactory.getLogger(TestService.class);

    private static AtomicInteger count = new AtomicInteger(0);

    ScheduledExecutorService executor = Executors.newScheduledThreadPool(10);

    public void processDelay() throws InterruptedException {
        logger.info("process count {} step 1 ", count.getAndIncrement());
        executor.schedule(() ->  logger.info("process step 2"), 5, TimeUnit.SECONDS);
    }

    public void processDelayWithThreadSleep() throws InterruptedException {
        logger.info("process count {} step 1 ", count.getAndIncrement());
        Thread.sleep(5000);
        logger.info("process step 2");
    }

}

