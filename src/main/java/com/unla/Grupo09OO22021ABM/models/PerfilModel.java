package com.unla.Grupo09OO22021ABM.models;

public class PerfilModel {
	private int id_perfil;
	private String tipo_perfil;
	private boolean enabled;
	
	public PerfilModel() {}

	public PerfilModel(int id_perfil, String tipo_perfil) {
		super();
		this.id_perfil = id_perfil;
		this.tipo_perfil = tipo_perfil;
		this.enabled = true;
	}

	public PerfilModel(String tipo_perfil) {
		super();
		this.tipo_perfil = tipo_perfil;
		this.enabled = true;
	}

	public int getId_perfil() {
		return id_perfil;
	}

	public void setId_perfil(int id_perfil) {
		this.id_perfil = id_perfil;
	}

	public String getTipo_perfil() {
		return tipo_perfil;
	}

	public void setTipo_perfil(String tipo_perfil) {
		this.tipo_perfil = tipo_perfil;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	

}
