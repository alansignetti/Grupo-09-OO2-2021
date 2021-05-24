package com.unla.Grupo09OO22021.models;

import java.util.Set;


public class PerfilModel {
	private int idPerfil;
	private String tipoPerfil;
	private Set<UsuarioModel> usuarios;
	

	public PerfilModel() {}
	
	
	// me basé en el degreeModel y tiene el int -- Alan
	public PerfilModel(int id,String tipoPerfil) {
		super();
		this.setIdPerfil(id);
		this.tipoPerfil = tipoPerfil;
	}
//	public PerfilModel(int id,String tipoPerfil, Set<UsuarioModel> usuarios) {
//		super();
//		this.setIdPerfil(id);
//		this.tipoPerfil = tipoPerfil;
//		this.usuarios = usuarios;
//	}

	public int getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getTipoPerfil() {
		return tipoPerfil;
	}

	public void setTipoPerfil(String tipoPerfil) {
		this.tipoPerfil = tipoPerfil;
	}

	public Set<UsuarioModel> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<UsuarioModel> usuarios) {
		this.usuarios = usuarios;
	}
	
	
	
	
	
	
}
