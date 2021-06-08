package com.unla.Grupo09OO22021ABM.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "permiso_diario")
@PrimaryKeyJoinColumn(name = "id_permiso")
public class PermisoDiario extends Permiso{
	
	@Column(name = "motivo", nullable=false)
	private String motivo;
	
	public PermisoDiario() {}
	
	public PermisoDiario( Persona pedido, LocalDate fecha, String motivo) {
		super(pedido, fecha);
		this.motivo = motivo;
	}

	public PermisoDiario(String motivo) {
		super();
		this.motivo = motivo;
	}
	
	
	
	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	@Override
	public String toString() {
		return "PermisoDiario [motivo=" + motivo + "]";
	}

	
	
	



}
