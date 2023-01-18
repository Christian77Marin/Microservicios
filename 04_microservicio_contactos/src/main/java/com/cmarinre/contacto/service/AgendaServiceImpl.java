package com.cmarinre.contacto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmarinre.contacto.dao.AgendaDao;
import com.cmarinre.contacto.model.Contacto;

@Service
public class AgendaServiceImpl implements AgendaService {

	@Autowired
	AgendaDao dao;
	
	@Override
	public boolean agregarContacto(Contacto contacto) {
		if(dao.recuperarContacto(contacto.getIdContacto()) == null) {
			dao.agregarContacto(contacto);
			return true;
		}
		return false;
	}

	@Override
	public List<Contacto> recuperarContactos() {
		return dao.devolverContactos();
	}

	@Override
	public void actualizarContacto(Contacto contacto) {
		if(dao.recuperarContacto(contacto.getIdContacto()) != null) {
			dao.actualizarContacto(contacto);
		}
	}

	@Override
	public boolean eliminarContacto(int idContacto) {
		if(dao.recuperarContacto(idContacto) != null) {
			dao.eliminarContacto(idContacto);
			return false;
		}
		return false;
	}

	@Override
	public Contacto buscarContacto(int idContacto) {
		// TODO Auto-generated method stub
		return dao.recuperarContacto(idContacto);
	}

}
