package com.cmarinre.contacto.dao;

import java.util.List;

import com.cmarinre.contacto.model.Contacto;

public interface AgendaDao {
	void agregarContacto(Contacto contacto);

	Contacto recuperarContacto(String email);

	void eliminarContacto(String email);

	List<Contacto> devolverContactos();
	
	void eliminarContacto(int idContacto);
	
	Contacto recuperarContacto(int idContacto);
	
	void actualizarContacto(Contacto contacto);
}
