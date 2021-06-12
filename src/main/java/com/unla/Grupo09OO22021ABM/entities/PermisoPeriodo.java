package com.unla.Grupo09OO22021ABM.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "permiso_periodo")
@PrimaryKeyJoinColumn(name = "id_permiso")
public class PermisoPeriodo extends Permiso{
	
	@Column(name = "cantDias", nullable=false)
	@NotNull(message = "Por favor, ingrese la Cantidad de Dias deseada.")
	private int cantDias;
	
	@Column(name = "vacaciones", nullable=false, columnDefinition = "boolean default true")
	private boolean vacaciones = true;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_rodado")
	private Rodado rodado;
	
	public PermisoPeriodo() {}

	public PermisoPeriodo(Persona pedido, LocalDate fecha, int cantDias, boolean vacaciones, Rodado rodado) {
		super(pedido, fecha);
		this.cantDias = cantDias;
		this.vacaciones = vacaciones;
		this.setRodado(rodado);
	}

	public PermisoPeriodo(int cantDias, boolean vacaciones, Rodado rodado) {
		super();
		this.cantDias = cantDias;
		this.vacaciones = vacaciones;
		this.setRodado(rodado);
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

	public Rodado getRodado() {
		return rodado;
	}

	public void setRodado(Rodado rodado) {
		this.rodado = rodado;
	}

	@Override
	public String toString() {
		return "PermisoPeriodo [cantDias=" + cantDias + ", vacaciones=" + vacaciones + ", rodado=" + rodado + "]";
	}
		
}
