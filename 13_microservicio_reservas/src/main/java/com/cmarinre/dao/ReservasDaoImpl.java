package com.cmarinre.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cmarinre.model.Reserva;

@Repository
public class ReservasDaoImpl implements ReservasDao {

	@Autowired
	ReservasJpaSpring reservas;
	
	@Override
	public void generarReserva (Reserva reserva) {
		reservas.save(reserva);
	}
	
	@Override
	public List<Reserva> getReservas(){
		return reservas.findAll();
	}
	
}
