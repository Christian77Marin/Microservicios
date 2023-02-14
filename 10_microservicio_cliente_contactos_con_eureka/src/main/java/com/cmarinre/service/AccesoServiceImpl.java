package com.cmarinre.service;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cmarinre.model.Persona;

@Service
public class AccesoServiceImpl implements AccesoService{

	@Autowired
	RestTemplate template;
	
//	String url= "http://localhost:8080";
	String url= "http://servicio-contactos";
	
	@Override
	@Async
	public CompletableFuture<List<Persona>> llamadaServicio(Persona persona){
		template.postForLocation(url + "/contactos" , persona);
		Persona[] personas = template.getForObject(url + "/contactos", Persona[].class);
		
		return CompletableFuture.completedFuture(Arrays.asList(personas));
	}
	
	
	@Override
	@Async
	public CompletableFuture<List<Persona>> buscarPorEdadesAsync(int edad1, int edad2){
		Persona[] personas = template.getForObject(url + "/contactos", Persona[].class);
		
		return CompletableFuture.completedFuture(Arrays.stream(personas).filter(n -> n.getEdad() >= edad1 && n.getEdad() <= edad2)
				.collect(Collectors.toList()));
	}
	
}
