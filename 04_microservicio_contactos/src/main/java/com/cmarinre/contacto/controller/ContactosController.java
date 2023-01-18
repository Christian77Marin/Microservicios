package com.cmarinre.contacto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import com.cmarinre.contacto.model.Contacto;
import com.cmarinre.contacto.service.AgendaService;

@RestController
public class ContactosController {
	
	@Autowired
	AgendaService service;
	
	@GetMapping(value="contactos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Contacto> recuperarContactos(){
		return service.recuperarContactos();
	}
	
	@GetMapping(value="contactos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Contacto recuperarContacto(@PathVariable("id") int id){
		return service.buscarContacto(id);
	}
	
	@PostMapping(value="contactos",consumes= MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
	public void actualizarContacto(@RequestBody Contacto contacto) {
			service.actualizarContacto(contacto);
	}
	
	@DeleteMapping(value="contactos/{id}")
	public void eliminarContacto(@PathVariable("id") int id) {
			service.eliminarContacto(id);
	}
	
	

}
