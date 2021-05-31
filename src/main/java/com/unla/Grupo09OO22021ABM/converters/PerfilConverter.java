package com.unla.Grupo09OO22021ABM.converters;

import org.springframework.stereotype.Component;

import com.unla.Grupo09OO22021ABM.entities.Perfil;
import com.unla.Grupo09OO22021ABM.models.PerfilModel;

@Component("perfilConverter")
public class PerfilConverter {
	
	public PerfilModel entityToModel(Perfil perfil) {
		return new PerfilModel(perfil.getId_perfil(), perfil.getTipo_perfil());
	}
	
	public Perfil modelToEntity(PerfilModel perfilModel) {
		return new Perfil(perfilModel.getId_perfil(), perfilModel.getTipo_perfil());
	}

}
