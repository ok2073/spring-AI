package com.keelient.functions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(WeatherConfigProperties.class)
@SpringBootApplication
public class FunctionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FunctionsApplication.class, args);
	}

}
