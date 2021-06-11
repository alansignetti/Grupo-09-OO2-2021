package com.unla.Grupo09OO22021ABM.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "persona")
public class Persona {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_persona;
	
	@Column(name = "nombre")
	@NotEmpty
	@Size(min=2, message="Nombre requerido")
	@Pattern(regexp = "^[a-zA-Z]$", message ="Solo se permite Letras. Por favor, intente nuevamente.")
	private String nombre;

	@Column(name = "apellido")
	@NotEmpty
	@Size(min=2, message="Apellido requerido")
	@Pattern(regexp = "^[a-zA-Z]$", message ="Solo se permite Letras. Por favor, intente nuevamente.")
	private String apellido;

	@Column(name = "dni")
	@NotNull
	//@Pattern(regexp = "^[[\\d]$", message ="Solo se permiten Digitos. Por favor, intente nuevamente.")
	private long dni;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pedido")
	private Set<Permiso> permiso;


	public Persona() {}

	public Persona(String nombre, String apellido, long dni) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}

	public int getId_persona() {
		return id_persona;
	}

	public void setId_persona(int id_persona) {
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

	@Override
	public String toString() {	
		return "DNI: " + dni +" ("+ nombre +" "+ apellido +")";
	}


}
