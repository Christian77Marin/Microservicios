package com.cmarinre.controller;


import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import com.cmarinre.model.Persona;
import com.cmarinre.service.AccesoService;

@RestController
public class PersonasController {

	@Autowired
	AccesoService accesoService;
	
	
	@GetMapping(value = "personas/{nombre}/{email}/{edad}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Persona> altaPersona(@PathVariable("nombre") String nombre, 
			@PathVariable("email") String email,
			@PathVariable("edad") int edad){
		Persona persona = new Persona(nombre,email,edad);
		CompletableFuture<List<Persona>> resultado = accesoService.llamadaServicio(persona);
		for(int i =1; i<50; i++) {
			System.out.println("esperando ");
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		try {
			return resultado.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@GetMapping(value = "personas/{edad1}/{edad2}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Persona> buscarPorEdades(@PathVariable("edad1") int edad1,@PathVariable("edad2") int edad2){
		CompletableFuture<List<Persona>> resultado = accesoService.buscarPorEdadesAsync(edad1, edad2);
		
		try {
			return resultado.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	
}
