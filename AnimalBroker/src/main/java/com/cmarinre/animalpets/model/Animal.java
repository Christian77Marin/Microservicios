package com.cmarinre.animalpets.model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the animal database table.
 * 
 */
@Entity
@NamedQuery(name="Animal.findAll", query="SELECT a FROM Animal a")
public class Animal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAnimal;

	private String especie;

	private byte terrestre;

	private byte vertebrado;

	public Animal() {
	}

	public int getIdAnimal() {
		return this.idAnimal;
	}

	public void setIdAnimal(int idAnimal) {
		this.idAnimal = idAnimal;
	}

	public String getEspecie() {
		return this.especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public byte getTerrestre() {
		return this.terrestre;
	}

	public void setTerrestre(byte terrestre) {
		this.terrestre = terrestre;
	}

	public byte getVertebrado() {
		return this.vertebrado;
	}

	public void setVertebrado(byte vertebrado) {
		this.vertebrado = vertebrado;
	}

}