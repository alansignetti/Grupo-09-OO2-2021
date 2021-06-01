package com.unla.Grupo09OO22021ABM.models;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class PermisoModel {

	private int id_permiso;
	private PersonaModel pedido;
	private LocalDate fecha;
	private Set<LugarModel> desdeHasta;

	public PermisoModel() {}

	public PermisoModel(PersonaModel pedido, LocalDate fecha) {
		super();
		this.pedido = pedido;
		this.fecha = fecha;
		this.desdeHasta = new HashSet<LugarModel>();
	}
	

	public int getId_permiso() {
		return id_permiso;
	}

	public void setId_permiso(int id_permiso) {
		this.id_permiso = id_permiso;
	}

	public PersonaModel getPedido() {
		return pedido;
	}

	public void setPedido(PersonaModel pedido) {
		this.pedido = pedido;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Set<LugarModel> getDesdeHasta() {
		return desdeHasta;
	}

	public void setDesdeHasta(Set<LugarModel> desdeHasta) {
		this.desdeHasta = desdeHasta;
	}



}