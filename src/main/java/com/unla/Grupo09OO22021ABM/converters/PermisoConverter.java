package com.unla.Grupo09OO22021ABM.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.unla.Grupo09OO22021ABM.entities.Permiso;
import com.unla.Grupo09OO22021ABM.models.PermisoModel;

@Component("permisoConverter")
public class PermisoConverter {
	
	@Autowired
	@Qualifier("personaConverter")
	private PersonaConverter personaConverter;
	
	public PermisoModel entityToModel(Permiso permiso) {
		return new PermisoModel(personaConverter.entityToModel(permiso.getPedido()), permiso.getFecha() );
	}
	
	public Permiso modelToEntity (PermisoModel permisoModel) {
		return new Permiso (personaConverter.modelToEntity(permisoModel.getPedido()), permisoModel.getFecha());
	}

}
