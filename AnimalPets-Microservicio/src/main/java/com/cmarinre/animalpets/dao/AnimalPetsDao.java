package com.cmarinre.animalpets.dao;

import java.util.List;

import com.cmarinre.animalpets.model.Animal;
import com.cmarinre.animalpets.model.Mascota;

public interface AnimalPetsDao {
	
	void addAnimal(Animal animal);
	void updateAnimal(Animal animal);
//	Animal findAnimalByStatus(String status);
	Animal findAnimalById(int id);
	void deleteAnimal(int id);
	List<Animal> animalFullList();
	
	void addPet(Mascota mascota);
	void updatePet(Mascota mascota);
	Mascota findPetById(int id);
	void deletePet(int id);
	List<Mascota> petFullList();
}
