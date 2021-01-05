package com.ouag.poc.aopparentdemo.services;

import com.ouag.poc.aopparentdemo.aop.NotificationField;
import com.ouag.poc.aopparentdemo.aop.TrackThat;

public interface IRegularService {

    @TrackThat(advices = {"getLoggerAdvice","getLoggerAdvice"})
    void processServiceOne(String firstArg, @NotificationField String secondArg);

}
