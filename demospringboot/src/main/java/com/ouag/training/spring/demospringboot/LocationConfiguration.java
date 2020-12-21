package com.ouag.training.spring.demospringboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LocationConfiguration {

    @Bean
    public LocationService getLocationService(){
        return new LocationService();
    }

    @Bean
    public ProfileService getProfileService(){
        return new ProfileService();
    }
}
