package com.cmarinre.animalpets.model;

import java.io.Serializable;
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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMascota;

	private int animalId;

	private String dniDueño;

	private String estado;

	private String nombreMascota;

	private byte seguroMedico;

	public Mascota() {
	}

	public int getIdMascota() {
		return this.idMascota;
	}

	public void setIdMascota(int idMascota) {
		this.idMascota = idMascota;
	}

	public int getAnimalId() {
		return this.animalId;
	}

	public void setAnimalId(int animalId) {
		this.animalId = animalId;
	}

	public String getDniDueño() {
		return this.dniDueño;
	}

	public void setDniDueño(String dniDueño) {
		this.dniDueño = dniDueño;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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

}