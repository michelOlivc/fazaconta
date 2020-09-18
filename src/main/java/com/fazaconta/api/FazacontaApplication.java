package com.fazaconta.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.fazaconta.api")
public class FazacontaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FazacontaApplication.class, args);
	}

}
