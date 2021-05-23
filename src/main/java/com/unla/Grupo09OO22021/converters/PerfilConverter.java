package com.unla.Grupo09OO22021.converters;

import org.springframework.stereotype.Component;

import com.unla.Grupo09OO22021.entities.Perfil;
import com.unla.Grupo09OO22021.models.PerfilModel;

@Component("perfilConverter")
public class PerfilConverter {

	public PerfilModel entityToModel(Perfil perfil) {
		return new PerfilModel(perfil.getIdPerfil(), perfil.getTipoPerfil());
	}

	public Perfil modelToEntity(PerfilModel perfilModel) {
		return new Perfil(perfilModel.getIdPerfil(), perfilModel.getTipoPerfil());
	}
}

