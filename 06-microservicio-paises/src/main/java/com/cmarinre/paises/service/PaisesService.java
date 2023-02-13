package com.cmarinre.paises.service;

import java.util.List;

import com.cmarinre.paises.model.Pais;

public interface PaisesService {

	List<Pais> obtenerPaises();

	List<Pais> buscarPaises(String name);

}