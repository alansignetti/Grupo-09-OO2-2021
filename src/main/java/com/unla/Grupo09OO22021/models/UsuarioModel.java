package com.unla.Grupo09OO22021.models;

public class UsuarioModel {
	private int id;
	private String username;
	private String password;
	private PerfilModel perfil;

	public UsuarioModel() {
		super();
	}

	public UsuarioModel(int id, String username, String password, PerfilModel perfil) {
		super();
		this.setId(id);
		this.username = username;
		this.password = password;
		this.perfil = perfil;
	}
	public UsuarioModel(int id, String username, String password) {
		super();
		this.setId(id);
		this.username = username;
		this.password = password;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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