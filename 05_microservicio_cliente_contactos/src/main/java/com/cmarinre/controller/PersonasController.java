package com.cmarinre.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cmarinre.model.Persona;
import com.cmarinre.service.AccesoService;

@RestController
public class PersonasController {

	@Autowired
	AccesoService accesoSe;
	
	
	@GetMapping(value = "personas/{nombre}/{email}/{edad}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Persona> altaPersona(@PathVariable("nombre") String nombre, 
			@PathVariable("email") String email,
			@PathVariable("edad") int edad){
		Persona persona = new Persona(nombre,email,edad);
		
		
		return Arrays.asList(personas);
	}
	
	@GetMapping(value = "personas/{edad1}/{edad2}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Persona> buscarPorEdades(@PathVariable("edad1") int edad1,@PathVariable("edad2") int edad2){
		Persona[] personas = template.getForObject(url + "/contactos", Persona[].class);
		return Arrays.stream(personas).filter(n -> n.getEdad() >= edad1 && n.getEdad() <= edad2)
				.collect(Collectors.toList());
	}
	
	
	
	
}
