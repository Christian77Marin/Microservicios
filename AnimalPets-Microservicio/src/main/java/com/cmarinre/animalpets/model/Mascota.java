package com.cmarinre.animalpets.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;


/**
 * The persistent class for the mascota database table.
 * 
 */
@Entity
@NamedQuery(name="Mascota.findAll", query="SELECT m FROM Mascota m")
public class Mascota implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idMascota;

	private String dniDueño;

	private String nombreMascota;

	private byte seguroMedico;

	//bi-directional one-to-one association to Animal
	@OneToOne(mappedBy="mascota")
	@JsonManagedReference
	private Animal animal;

	public Mascota() {
	}

	public int getIdMascota() {
		return this.idMascota;
	}

	public void setIdMascota(int idMascota) {
		this.idMascota = idMascota;
	}

	public String getDniDueño() {
		return this.dniDueño;
	}

	public void setDniDueño(String dniDueño) {
		this.dniDueño = dniDueño;
	}

	public String getNombreMascota() {
		return this.nombreMascota;
	}

	public void setNombreMascota(String nombreMascota) {
		this.nombreMascota = nombreMascota;
	}

	public byte getSeguroMedico() {
		return this.seguroMedico;
	}

	public void setSeguroMedico(byte seguroMedico) {
		this.seguroMedico = seguroMedico;
	}

	public Animal getAnimal() {
		return this.animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

}