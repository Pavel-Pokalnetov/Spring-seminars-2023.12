package ru.gb.pokalnetovps.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Hw9Application {

	public static void main(String[] args) {
		SpringApplication.run(Hw9Application.class, args);
	}

}
