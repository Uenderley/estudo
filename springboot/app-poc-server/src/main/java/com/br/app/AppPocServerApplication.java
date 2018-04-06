package com.br.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AppPocServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppPocServerApplication.class, args);
	}
}
