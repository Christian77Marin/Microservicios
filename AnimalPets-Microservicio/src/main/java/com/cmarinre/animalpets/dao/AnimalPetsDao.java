package com.cmarinre.animalpets.dao;

import java.util.List;

import com.cmarinre.animalpets.model.Animal;

public interface AnimalPetsDao {
	
	void addAnimal(Animal animal);
	void updateAnimal(Animal animal);
//	Animal findAnimalByStatus(String status);
	Animal findAnimalById(int id);
	void deleteAnimal(int id);
	List<Animal> animalFullList();
}
