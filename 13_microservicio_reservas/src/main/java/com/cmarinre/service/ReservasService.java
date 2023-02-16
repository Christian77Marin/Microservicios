package com.cmarinre.service;

import java.util.List;

import com.cmarinre.model.Reserva;

public interface ReservasService {

	void realizarReserva(Reserva reserva, int totalPersonas);

	List<Reserva> getReservas();

}