package com.portfolio.beerapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@Profile("!test")
public class BeerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeerAppApplication.class, args);
	}
}
