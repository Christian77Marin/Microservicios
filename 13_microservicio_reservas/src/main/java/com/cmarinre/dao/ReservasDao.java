package com.cmarinre.dao;

import java.util.List;

import com.cmarinre.model.Reserva;

public interface ReservasDao {

	void generarReserva(Reserva reserva);

	List<Reserva> getReservas();

}