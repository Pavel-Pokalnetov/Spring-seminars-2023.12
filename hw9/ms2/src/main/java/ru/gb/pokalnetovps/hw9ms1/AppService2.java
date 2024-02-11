package ru.gb.pokalnetovps.hw9ms1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AppService2 {

	public static void main(String[] args) {
		SpringApplication.run(AppService2.class, args);
	}

}
