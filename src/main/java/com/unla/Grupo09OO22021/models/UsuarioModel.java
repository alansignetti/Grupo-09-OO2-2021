package com.unla.Grupo09OO22021.models;

public class UsuarioModel {
	private int idUsuario;
	private String username;
	private String password;
	private PerfilModel perfil;

	public UsuarioModel() {
		super();
	}

	public UsuarioModel(int idUsuario, String username, String password, PerfilModel perfil) {
		super();
		this.setIdUsuario(idUsuario);
		this.username = username;
		this.password = password;
		this.perfil = perfil;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public PerfilModel getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilModel perfil) {
		this.perfil = perfil;
	}

	
}