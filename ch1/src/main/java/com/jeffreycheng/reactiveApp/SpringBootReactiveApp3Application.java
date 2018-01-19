package com.jeffreycheng.reactiveApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class SpringBootReactiveApp3Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootReactiveApp3Application.class, args);
	}
}
