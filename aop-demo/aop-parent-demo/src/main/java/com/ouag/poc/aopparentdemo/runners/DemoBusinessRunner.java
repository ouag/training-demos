package com.ouag.poc.aopparentdemo.runners;

import com.ouag.poc.aopparentdemo.services.IRegularService;
import com.ouag.poc.aopparentdemo.services.RegularService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

@Slf4j
@AllArgsConstructor
public class DemoBusinessRunner implements ApplicationRunner {

    private IRegularService regularService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //Thread.sleep(5000);
        regularService.processServiceOne("un", "deux");
    }
}
