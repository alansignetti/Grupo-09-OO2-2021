package com.unla.Grupo09OO22021ABM.models;

public class RodadoModel {
	
	private int idRodado;
	private String dominio;
	private String vehiculo;
	
	public RodadoModel() {}
	
	public RodadoModel(String dominio, String vehiculo) {
		super();
		this.dominio = dominio;
		this.vehiculo = vehiculo;
	}

	public int getIdRodado() {
		return idRodado;
	}

	public void setIdRodado(int idRodado) {
		this.idRodado = idRodado;
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
	
	
	
	

}
