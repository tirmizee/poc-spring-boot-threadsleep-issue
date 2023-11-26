package com.tirmizee.controllers;

import com.tirmizee.services.TestService;
import org.apache.catalina.startup.Tomcat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
public class TestController {

    @Autowired
    private TestService testService;



    @GetMapping("/test")
    public String testThreadSleep() throws InterruptedException, ExecutionException {
        testService.processDelay();
        return "success";
    }

}
