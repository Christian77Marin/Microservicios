package com.cmarinre.animalpets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"com.cmarinre.animalpets.controller","com.cmarinre.animalpets.dao","com.cmarinre.animalpets.service"})
@EntityScan(basePackages = {"com.cmarinre.animalpets.model"})
@EnableJpaRepositories(basePackages = {"com.cmarinre.animalpets.dao"})
@SpringBootApplication
@EnableAutoConfiguration
public class AnimalPetsMicroservicioApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimalPetsMicroservicioApplication.class, args);
	}

}
