package com.unla.Grupo09OO22021ABM.models;

import java.time.LocalDate;

public class PermisoDiarioModel extends PermisoModel{
	
	private String motivo;

	public PermisoDiarioModel() {
		super();
	}

	public PermisoDiarioModel(PersonaModel pedido, LocalDate fecha, String motivo) {
		super(pedido, fecha);
		this.motivo = motivo;
	}

	public PermisoDiarioModel(String motivo) {
		super();
		this.motivo = motivo;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	
	

}
