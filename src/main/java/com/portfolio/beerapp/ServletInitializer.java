package com.portfolio.beerapp;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		SpringApplicationBuilder springApplicationBuilder = application.sources(BeerAppApplication.class);
	
		return springApplicationBuilder;
	}
	

}
