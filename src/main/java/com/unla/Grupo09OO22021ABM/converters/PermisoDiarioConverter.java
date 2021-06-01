package com.unla.Grupo09OO22021ABM.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.unla.Grupo09OO22021ABM.entities.PermisoDiario;
import com.unla.Grupo09OO22021ABM.models.PermisoDiarioModel;

@Component("permisoDiarioConverter")
public class PermisoDiarioConverter {
	
	@Autowired
	@Qualifier("personaConverter")
	private PersonaConverter personaConverter;
	
	public PermisoDiarioModel entityToModel(PermisoDiario pd) {
		return new PermisoDiarioModel(personaConverter.entityToModel(pd.getPedido()), pd.getFecha(), pd.getMotivo());
	}
	
	public PermisoDiario modelToEntity (PermisoDiarioModel pdm) {
		return new PermisoDiario (personaConverter.modelToEntity(pdm.getPedido()), pdm.getFecha(), pdm.getMotivo());
	}

}
