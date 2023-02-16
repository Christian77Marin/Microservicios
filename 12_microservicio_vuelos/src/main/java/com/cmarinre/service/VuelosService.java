package com.cmarinre.service;

import java.util.List;

import com.cmarinre.model.Vuelo;

public interface VuelosService {

	List<Vuelo> recuperarVuelosDisponibles(int plazas);

	void actualizarPlazas(int id, int plazas);

}