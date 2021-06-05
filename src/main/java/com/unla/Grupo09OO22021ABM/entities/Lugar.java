package com.unla.Grupo09OO22021ABM.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "lugar")
public class Lugar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_lugar;

	@Column(name = "lugar", nullable=false, length=100)
	private String lugar;
	
	@Column(name = "codigo_postal", nullable=false, length=45)
	private String codigo_postal;
	
	@ManyToMany(mappedBy="desdeHasta")
	private Set<Permiso> permisos;
	
	/*@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="permisoxlugar", 
	joinColumns=@JoinColumn (name="id_lugar"),
	inverseJoinColumns= @JoinColumn(name="id_permiso"))
	private Set<Permiso> permisos;*/

	/*@ManyToMany(mappedBy = "desdeHasta")
    private Set<Permiso> permisos;*/

	public Lugar() {}

	public Lugar(String lugar, String codigo_postal) {
		super();
		this.lugar = lugar;
		this.codigo_postal = codigo_postal;
		this.permisos = new HashSet<Permiso>();
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

	public Set<Permiso> getPermisos() {
		return permisos;
	}

	public void setPermisos(Set<Permiso> permisos) {
		this.permisos = permisos;
	}

}
