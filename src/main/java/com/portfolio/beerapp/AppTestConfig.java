package com.portfolio.beerapp;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * PORTFOLIO BEER - JAVA TEST APPLICATION
 *
 */
@Configuration
@Profile("test")
@ComponentScan({"com.portfolio.beerapp.*"})
@EntityScan(basePackages = "com.portfolio.beerapp.entity") 
@EnableJpaRepositories
@PropertySource("classpath:application.properties")
public class AppTestConfig
{	

}
