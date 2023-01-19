package com.cmarinre.animalpets.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cmarinre.animalpets.model.Animal;

@Repository
public class AnimalPetsDaoImpl implements AnimalPetsDao {

	@Autowired
	AnimalPetsJpaSpring saver;
	
	@Override
	public void addAnimal(Animal animal) {
		saver.save(animal);
	}

	@Override
	public void updateAnimal(Animal animal) {
		saver.save(animal);

	}

//	@Override
//	public Animal findAnimalByStatus(String status) {
//		return saver.findByStatus(status);
//	}

	@Override
	public Animal findAnimalById(int id) {
		
		return saver.findById(id).orElse(null);
	}

	@Override
	public void deleteAnimal(int id) {
		saver.deleteById(id);

	}

	@Override
	public List<Animal> animalFullList() {
		
		return saver.findAll();
	}

}
