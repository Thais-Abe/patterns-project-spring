package com.project.thais.project_patterns_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ProjectPatternsSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectPatternsSpringApplication.class, args);
	}

}
