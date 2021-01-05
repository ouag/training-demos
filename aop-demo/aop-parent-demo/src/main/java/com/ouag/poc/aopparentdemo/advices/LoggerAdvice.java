package com.ouag.poc.aopparentdemo.advices;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoggerAdvice implements DemoAdvice {
    @Override
    public void process(String notification) {
        log.info("logger advice says {}", notification);
    }
}
