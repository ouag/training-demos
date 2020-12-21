package com.ouag.training.spring.demospringboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@Slf4j
@SpringBootApplication
@EnableConfigurationProperties(LocationProperties.class)
public class DemospringbootApplication {


	public static void main(String[] args) {
		SpringApplication.run(DemospringbootApplication.class, args);
	}

}
