package com.unla.Grupo09OO22021ABM.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "permiso")
@Inheritance(strategy = InheritanceType.JOINED)
public class Permiso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id_permiso;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_persona")
	protected Persona pedido;

	@Column(name = "fecha", nullable=false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	protected LocalDate fecha;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="permisoxlugar", 
	joinColumns=@JoinColumn (name="id_permiso"),
	inverseJoinColumns= @JoinColumn(name="idLugar"))
	private Set<Lugar> desdeHasta;
	

	public Permiso() {}

	public Permiso(Persona pedido, LocalDate fecha) {
		super();
		this.pedido = pedido;
		this.fecha = fecha;
		this.desdeHasta = new HashSet<Lugar>();
	}

	public int getId_permiso() {
		return id_permiso;
	}

	public void setId_permiso(int id_permiso) {
		this.id_permiso = id_permiso;
	}

	public Persona getPedido() {
		return pedido;
	}

	public void setPedido(Persona pedido) {
		this.pedido = pedido;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Set<Lugar> getDesdeHasta() {
		return desdeHasta;
	}

	public void setDesdeHasta(Set<Lugar> desdeHasta) {
		this.desdeHasta = desdeHasta;
	}

	
	public void addLugarDesdeHasta(Lugar lugar) {
		desdeHasta.add(lugar);
		
	}
}