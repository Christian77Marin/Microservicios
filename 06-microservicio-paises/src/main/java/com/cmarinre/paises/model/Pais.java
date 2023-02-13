package com.cmarinre.paises.model;

public class Pais {
	private String nombre;
	private String capital;
	private int poblacion;
	private String bandera;
	
	public Pais(String nombre, String capital, int poblacion, String bandera) {
		super();
		this.setNombre(nombre);
		this.setCapital(capital);
		this.setBandera(bandera);
		this.setPoblacion(poblacion);
	}
	
	public Pais() {};

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(int poblacion) {
		this.poblacion = poblacion;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getBandera() {
		return bandera;
	}

	public void setBandera(String bandera) {
		this.bandera = bandera;
	}

}
