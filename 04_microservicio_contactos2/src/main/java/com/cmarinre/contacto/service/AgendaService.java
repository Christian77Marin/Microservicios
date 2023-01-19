package com.cmarinre.contacto.service;

import java.util.List;

import com.cmarinre.contacto.model.Contacto;

public interface AgendaService {
	
	boolean agregarContacto(Contacto contacto);
	
	List<Contacto> recuperarContactos();
	
	void actualizarContacto(Contacto contacto);
	
	boolean eliminarContacto(int idContacto);
	
	Contacto buscarContacto(int idContacto);
	
}
