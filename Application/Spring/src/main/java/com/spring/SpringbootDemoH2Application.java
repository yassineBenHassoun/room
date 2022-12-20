package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories("com.spring.repository")
public class SpringbootDemoH2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoH2Application.class, args);
	}

}
