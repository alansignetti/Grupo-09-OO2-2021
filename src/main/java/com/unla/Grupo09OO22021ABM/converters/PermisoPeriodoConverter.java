package com.unla.Grupo09OO22021ABM.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.unla.Grupo09OO22021ABM.entities.PermisoPeriodo;
import com.unla.Grupo09OO22021ABM.models.PermisoPeriodoModel;

@Component("permisoPeriodoConverter")
public class PermisoPeriodoConverter {
	
	@Autowired
	@Qualifier("rodadoConverter")
	private RodadoConverter rodadoConverter;
	
	public PermisoPeriodoModel entityToModel (PermisoPeriodo pp) {
		return new PermisoPeriodoModel(pp.getCantDias(), pp.isVacaciones(), rodadoConverter.entityToModel(pp.getRodado()));		
	}
	
	public PermisoPeriodo modelToEntity(PermisoPeriodoModel ppm) {
		return new PermisoPeriodo(ppm.getCantDias(), ppm.isVacaciones(), rodadoConverter.modelToEntity(ppm.getRodado()));
	}

}
