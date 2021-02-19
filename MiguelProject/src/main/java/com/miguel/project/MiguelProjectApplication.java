package com.miguel.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.miguel.project.model.repository")
public class MiguelProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiguelProjectApplication.class, args);
	}

}
