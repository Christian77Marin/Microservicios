package com.cmarinre.animalpets.service;

import java.util.List;

import com.cmarinre.animalpets.model.Animal;
import com.cmarinre.animalpets.model.Mascota;

public interface AnimalPetsService {

	boolean addAnimal(Animal animal);
	List<Animal> animalFullList();
	void updateAnimal(Animal animal);
	void deleteAnimal(int id);
	Animal findAnimalById(int id);
//	Animal findAnimalByStatus(String status);
	
	boolean addPet(Mascota mascota);
	List<Mascota> petFullList();
	void updatePet(Mascota mascota);
	void deletePet(int id);
	Mascota findPetById(int id);
}
