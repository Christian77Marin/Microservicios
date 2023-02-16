package com.cmarinre.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cmarinre.model.Hotel;

@Repository
public class HotelesDaoImpl implements HotelesDao {

	@Autowired
	HotelesJpaSpring hoteles;
	
	@Override
	public List<Hotel> devolverHoteles(){
		return hoteles.findAll();
	}
	
}
