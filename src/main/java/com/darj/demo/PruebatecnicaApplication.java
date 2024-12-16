package com.darj.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.darj.demo.configuration.openapi.OpenApiConstants;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableCaching
@EnableAutoConfiguration
@EnableJpaRepositories
@OpenAPIDefinition(info = @Info(title = OpenApiConstants.TICKETS, version = OpenApiConstants.VERSION))
public class PruebatecnicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebatecnicaApplication.class, args);
	}

}
