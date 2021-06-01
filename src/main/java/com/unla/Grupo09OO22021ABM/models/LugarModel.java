package com.unla.Grupo09OO22021ABM.models;

import java.util.HashSet;
import java.util.Set;

public class LugarModel {

	private int id_lugar;
	private String lugar;
	private String codigo_postal;
	private Set<PermisoModel> permisos;

	public LugarModel() {}

	public LugarModel(String lugar, String codigo_postal) {
		super();
		this.lugar = lugar;
		this.codigo_postal = codigo_postal;
		this.permisos = new HashSet<PermisoModel>();
	}	

	public int getId_lugar() {
		return id_lugar;
	}

	public void setId_lugar(int id_lugar) {
		this.id_lugar = id_lugar;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getCodigo_postal() {
		return codigo_postal;
	}

	public void setCodigo_postal(String codigo_postal) {
		this.codigo_postal = codigo_postal;
	}

	public Set<PermisoModel> getPermisos() {
		return permisos;
	}

	public void setPermisos(Set<PermisoModel> permisos) {
		this.permisos = permisos;
	}

	

}