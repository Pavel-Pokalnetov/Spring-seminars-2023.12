package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication springApp = new SpringApplication(DemoApplication.class);
		springApp.setLogStartupInfo(false);
		springApp.run(args);
	}
}
