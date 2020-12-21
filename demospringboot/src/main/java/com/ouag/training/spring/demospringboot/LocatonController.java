package com.ouag.training.spring.demospringboot;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
public class LocatonController {


    private LocationProperties locationProperties;

    @Autowired
    public void setLocationProperties(LocationProperties locationProperties) {
        this.locationProperties = locationProperties;
    }

    private LocationService locationService;





    @GetMapping(path="location")
    public LocationProperties getLocation(){
        log.info("this is my location city : {}", locationProperties.getCity() );
        locationService.defineLocation();
        return locationProperties;
    }




}
