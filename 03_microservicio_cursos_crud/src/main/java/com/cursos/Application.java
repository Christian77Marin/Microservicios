package com.cursos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"controllers"}) --> Para scanear en otros packages que no esten en el principal
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
