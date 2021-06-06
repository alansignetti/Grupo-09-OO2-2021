package com.unla.Grupo09OO22021ABM.entities;



import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "rodado")
public class Rodado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_rodado;

	@Column(name = "dominio", nullable=false)
	private String dominio;
	
	@Column(name = "vehiculo", nullable=false)
	private String vehiculo;
	
	public Rodado() {}

	public Rodado(String dominio, String vehiculo) {
		super();
		this.dominio = dominio;
		this.vehiculo = vehiculo;
		//this.permisos_periodos = new HashSet<PermisoPeriodo>();
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
		return "Rodado [id_rodado=" + id_rodado + ", dominio=" + dominio + ", vehiculo=" + vehiculo + "]";
	}

	
	

}
