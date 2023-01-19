package com.cmarinre.animalpets.service;

import java.util.List;

import com.cmarinre.animalpets.model.Animal;

public interface AnimalPetsService {

	boolean addAnimal(Animal animal);
	List<Animal> animalFullList();
	void updateAnimal(Animal animal);
	void deleteAnimal(int id);
	Animal findAnimalById(int id);
//	Animal findAnimalByStatus(String status);
}
