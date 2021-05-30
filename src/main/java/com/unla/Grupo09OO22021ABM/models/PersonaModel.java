package com.unla.Grupo09OO22021ABM.models;

public class PersonaModel {

	private int id_persona;
	private String nombre;
	private String apellido;
	private long dni;

	public PersonaModel() {
	}

	public PersonaModel(int id_persona, String nombre, String apellido, long dni) {
		super();
		this.id_persona = id_persona;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}

	public int getIdPersona() {
		return id_persona;
	}

	public void setIdPersona(int id_persona) {
		this.id_persona = id_persona;
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

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}
}