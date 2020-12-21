package com.ouag.training.spring.demospringboot;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "location")
@Data
@Slf4j
public class LocationProperties {
    private String city;
}
