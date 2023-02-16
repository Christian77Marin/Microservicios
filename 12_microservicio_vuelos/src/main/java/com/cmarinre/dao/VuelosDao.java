package com.cmarinre.dao;

import java.util.List;

import com.cmarinre.model.Vuelo;

public interface VuelosDao {

	List<Vuelo> devolverVuelos();

	Vuelo devolverVuelo(int idVuelo);

	void actualizarVuelo(Vuelo vuelo);

}