package com.cmarinre.animalpets.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cmarinre.animalpets.model.Animal;
import com.cmarinre.animalpets.model.Mascota;
import com.cmarinre.animalpets.service.AnimalPetsService;


@RestController
public class AnimalPetsController {
	@Autowired
	AnimalPetsService service;
	
	@GetMapping(value="animals",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Animal> getAnimals() {
		System.out.println(service.animalFullList());
		return service.animalFullList();
	}
	@GetMapping(value="animal/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Animal getAnimal(@PathVariable("id") int id) {
		
		return service.findAnimalById(id);
	}
	
//	@GetMapping(value="pet/{status}",produces=MediaType.APPLICATION_JSON_VALUE)
//	public Animal getAnimal(@PathVariable("status") String status) {
//		return service.findAnimalByStatus(status);
//	}
	
	@PostMapping(value="animal",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.TEXT_PLAIN_VALUE)
	public String saveAnimal(@RequestBody Animal animal) {		
		return String.valueOf(service.addAnimal(animal));
	}
	
	@PutMapping(value="animal",consumes=MediaType.APPLICATION_JSON_VALUE)
	public void updateAnimal(@RequestBody Animal animal) {		
		service.updateAnimal(animal);
	}
		
	@DeleteMapping(value="animal/{id}")
	public void deleteAnimalById(@PathVariable("id") int id) {
		service.deleteAnimal(id);	
	}
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping(value="pets",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Mascota> getPets() {
		return service.petFullList();
	}
	@GetMapping(value="pet/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Mascota getPet(@PathVariable("id") int id) {
		
		return service.findPetById(id);
	}
	
//	@GetMapping(value="pet/{status}",produces=MediaType.APPLICATION_JSON_VALUE)
//	public Animal getAnimal(@PathVariable("status") String status) {
//		return service.findAnimalByStatus(status);
//	}
	
	@PostMapping(value="pet",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.TEXT_PLAIN_VALUE)
	public String savePet(@RequestBody Mascota mascota) {		
		return String.valueOf(service.addPet(mascota));
	}
	
	@PutMapping(value="pet",consumes=MediaType.APPLICATION_JSON_VALUE)
	public void updatePet(@RequestBody Mascota mascota) {		
		service.updatePet(mascota);
	}
		
	@DeleteMapping(value="pet/{id}")
	public void deletePetById(@PathVariable("id") int id) {
		service.deletePet(id);	
	}
	
	
	
}
