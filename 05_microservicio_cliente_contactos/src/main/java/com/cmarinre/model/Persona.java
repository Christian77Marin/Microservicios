package com.cmarinre.model;

public class Persona{
	
	private int edad;

	private String email;

	private String nombre;
	
	public Persona(String nombre, String email, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.email = email;
	}
	

	public Persona() {
		super();
	}



	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}