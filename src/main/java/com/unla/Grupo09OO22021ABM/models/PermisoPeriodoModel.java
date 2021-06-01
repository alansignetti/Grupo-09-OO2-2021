package com.unla.Grupo09OO22021ABM.models;

import java.time.LocalDate;

public class PermisoPeriodoModel extends PermisoModel{
	
	private int cantDias;
	private boolean vacaciones;
	private RodadoModel rodado;
	
	public PermisoPeriodoModel() {}

	public PermisoPeriodoModel(PersonaModel pedido, LocalDate fecha, int cantDias, boolean vacaciones,
			RodadoModel rodado) {
		super(pedido, fecha);
		this.cantDias = cantDias;
		this.vacaciones = vacaciones;
		this.rodado = rodado;
	}

	public PermisoPeriodoModel(int cantDias, boolean vacaciones, RodadoModel rodado) {
		super();
		this.cantDias = cantDias;
		this.vacaciones = vacaciones;
		this.rodado = rodado;
	}

	public int getCantDias() {
		return cantDias;
	}

	public void setCantDias(int cantDias) {
		this.cantDias = cantDias;
	}

	public boolean isVacaciones() {
		return vacaciones;
	}

	public void setVacaciones(boolean vacaciones) {
		this.vacaciones = vacaciones;
	}

	public RodadoModel getRodado() {
		return rodado;
	}

	public void setRodado(RodadoModel rodado) {
		this.rodado = rodado;
	}
	
	

}
