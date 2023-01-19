package com.cmarinre.animalpets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmarinre.animalpets.dao.AnimalPetsDao;
import com.cmarinre.animalpets.model.Animal;

@Service
public class AnimalPetsServiceImpl implements AnimalPetsService {

	@Autowired
	AnimalPetsDao dao;
	
	@Override
	public boolean addAnimal(Animal animal) {
		if(dao.findAnimalById(animal.getIdAnimal()) == null) {
			dao.addAnimal(animal);
			return true;
		}
		return false;
	}

	@Override
	public List<Animal> animalFullList() {
		return dao.animalFullList();
	}

	@Override
	public void updateAnimal(Animal animal) {
		if(dao.findAnimalById(animal.getIdAnimal()) != null) {
			dao.updateAnimal(animal);
		}
	}

	@Override
	public void deleteAnimal(int id) {
		if(dao.findAnimalById(id) != null) {
			
			dao.deleteAnimal(id);
		}

	}

	@Override
	public Animal findAnimalById(int id) {
		return dao.findAnimalById(id);
	}

//	@Override
//	public Animal findAnimalByStatus(String status) {
//		return dao.findAnimalByStatus(status);
//	}

}
