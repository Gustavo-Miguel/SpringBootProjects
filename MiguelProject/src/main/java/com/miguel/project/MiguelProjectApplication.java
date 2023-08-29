package com.miguel.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"org.project_utils.config.security", "com.miguel.project"})
@EnableJpaRepositories("com.miguel.project.model.repository")
public class MiguelProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiguelProjectApplication.class, args);
	}

}
