package com.cmarinre.animalpets.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cmarinre.animalpets.model.Animal;
import com.cmarinre.animalpets.model.Mascota;

@Repository
public class AnimalPetsDaoImpl implements AnimalPetsDao {

	@Autowired
	AnimalJpaSpring animalSaver;
	
	@Autowired
	PetJpaSpring petSaver;
	
	@Override
	public void addAnimal(Animal animal) {
		animalSaver.save(animal);
	}

	@Override
	public void updateAnimal(Animal animal) {
		animalSaver.save(animal);

	}

//	@Override
//	public Animal findAnimalByStatus(String status) {
//		return saver.findByStatus(status);
//	}

	@Override
	public Animal findAnimalById(int id) {
		
		return animalSaver.findById(id).orElse(null);
	}

	@Override
	public void deleteAnimal(int id) {
		animalSaver.deleteById(id);

	}

	@Override
	public List<Animal> animalFullList() {
		
		return animalSaver.findAll();
	}
	
	@Override
	public void addPet(Mascota mascota) {
		petSaver.save(mascota);
	}
	
	@Override
	public void deletePet(int id) {
		petSaver.deleteById(id);
	}
	
	@Override
	public Mascota findPetById(int id) {

		return petSaver.findById(id).orElse(null);
	}
	
	@Override
	public List<Mascota> petFullList() {
		System.out.println(petSaver.findAll());
		return petSaver.findAll();
	}

	@Override
	public void updatePet(Mascota mascota) {
		petSaver.save(mascota);
	}
}
