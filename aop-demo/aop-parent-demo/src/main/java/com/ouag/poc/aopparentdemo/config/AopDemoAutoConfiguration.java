package com.ouag.poc.aopparentdemo.config;


import com.ouag.poc.aopparentdemo.advices.DemoAdvice;
import com.ouag.poc.aopparentdemo.advices.LoggerAdvice;
import com.ouag.poc.aopparentdemo.aop.LoggingAspect;
import com.ouag.poc.aopparentdemo.runners.DemoBusinessRunner;
import com.ouag.poc.aopparentdemo.services.IRegularService;
import com.ouag.poc.aopparentdemo.services.RegularService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(LoggingAspect.class)
public class AopDemoAutoConfiguration {

    @Bean
    public DemoBusinessRunner getDemoBusinessRunner(IRegularService regularService){
        return new DemoBusinessRunner(regularService);
    }

    @Bean
    public IRegularService getRegularService(){
        return new RegularService();
    }

    @Bean
    public DemoAdvice getLoggerAdvice(){
        return new LoggerAdvice();
    }
}
