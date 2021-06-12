package com.unla.Grupo09OO22021ABM.entities;



import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "rodado")
public class Rodado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_rodado;

	@Column(name = "dominio", nullable=false)
	@NotEmpty
	@Size(min=6, message="Por favor, ingrese un Dominio.")
	private String dominio;
	
	@Column(name = "vehiculo", nullable=false)
	@NotEmpty
	@Size(min=2, message="Por favor, ingrese un Vehiculo.")
	private String vehiculo;
	
	public Rodado() {}

	public Rodado(String dominio, String vehiculo) {
		super();
		this.dominio = dominio;
		this.vehiculo = vehiculo;
	}

	public int getId_rodado() {
		return id_rodado;
	}

	public void setId_rodado(int id_rodado) {
		this.id_rodado = id_rodado;
	}

	public String getDominio() {
		return dominio;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}

	public String getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(String vehiculo) {
		this.vehiculo = vehiculo;
	}

	@Override
	public String toString() {
		return "Vehiculo: " + vehiculo+ "  ("+dominio+")";
	}



}
