package com.unla.Grupo09OO22021ABM.converters;

import org.springframework.stereotype.Component;

import com.unla.Grupo09OO22021ABM.entities.Rodado;
import com.unla.Grupo09OO22021ABM.models.RodadoModel;

@Component("rodadoConverter")
public class RodadoConverter {
	
	public RodadoModel entityToModel(Rodado rodado) {
		return new RodadoModel(rodado.getDominio(), rodado.getVehiculo());
	}
	
	public Rodado modelToEntity(RodadoModel rodadoModel) {
		return new Rodado(rodadoModel.getDominio(), rodadoModel.getVehiculo());
	}

}
