package com.cmarinre.contacto.inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@ComponentScan({"com.cmarinre.contacto.controller","com.cmarinre.contacto.dao", "com.cmarinre.contacto.service"})
@EntityScan("com.cmarinre.contacto.model")
@EnableJpaRepositories("com.cmarinre.contacto.dao")
@SpringBootApplication

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
