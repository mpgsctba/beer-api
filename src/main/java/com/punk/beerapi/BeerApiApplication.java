package com.punk.beerapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author marcossilva
 */
@EnableWebMvc
@SpringBootApplication
public class BeerApiApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(BeerApiApplication.class, args);
	}

}
