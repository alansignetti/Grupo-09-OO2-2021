package com.unla.Grupo09OO22021ABM.models;

public class UsuarioModel {
	
	private int id_usuario;
	private String nombre;
	private String apellido;
	private int tipo_dni;
	private long dni;
	private String email;
	private String username;
	private String password;
	private boolean enabled;
	
	public UsuarioModel() {}

	public UsuarioModel(int id_usuario, String nombre, String apellido, int tipo_dni, long dni, String email,
			String username, String password) {
		super();
		this.id_usuario = id_usuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipo_dni = tipo_dni;
		this.dni = dni;
		this.email = email;
		this.username = username;
		this.password = password;
		this.enabled = true;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getTipo_dni() {
		return tipo_dni;
	}

	public void setTipo_dni(int tipo_dni) {
		this.tipo_dni = tipo_dni;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	

}
