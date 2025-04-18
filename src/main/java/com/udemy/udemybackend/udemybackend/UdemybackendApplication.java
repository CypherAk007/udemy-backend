package com.udemy.udemybackend.udemybackend;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@OpenAPIDefinition
public class UdemybackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(UdemybackendApplication.class, args);
	}

}
