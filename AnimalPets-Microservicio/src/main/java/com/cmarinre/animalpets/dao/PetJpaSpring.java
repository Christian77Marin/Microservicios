package com.cmarinre.animalpets.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cmarinre.animalpets.model.Mascota;

public interface PetJpaSpring extends JpaRepository<Mascota, Integer> {
//	Animal findByStatus(String Estado);
}
