package com.ouag.training.spring.demospringboot;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Slf4j
public class LocationService {
    @Autowired
    private ProfileService profileService;

    public String defineLocation(){
        log.info("defining location ... ");
        return "algiers";
    }
}
