package com.ouag.poc.aopparentdemo.services;

import com.ouag.poc.aopparentdemo.aop.NotificationField;
import com.ouag.poc.aopparentdemo.aop.TrackThat;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RegularService implements  IRegularService{

    public void processServiceOne(String firstArg, @NotificationField String secondArg){
        log.info("Enter processServiceOne");
    }

}
