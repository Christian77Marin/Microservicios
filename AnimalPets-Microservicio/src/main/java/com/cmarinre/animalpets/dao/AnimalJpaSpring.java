package com.cmarinre.animalpets.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cmarinre.animalpets.model.Animal;

public interface AnimalJpaSpring extends JpaRepository<Animal, Integer> {
//	Animal findByStatus(String Estado);
}
