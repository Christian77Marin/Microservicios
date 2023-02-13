package com.cmarinre.paises;

import java.util.concurrent.Executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

@ComponentScan(basePackages = {"com.cmarinre.paises.controller","com.cmarinre.paises.service"})
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public RestTemplate template() {
		return new RestTemplate();
	}
	
	@Bean
	public Executor executor() {
		return new ThreadPoolTaskExecutor();
		
	}

}
