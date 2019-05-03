package br.jus.tse.publicador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PublicadorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PublicadorApplication.class, args);
	}

}

