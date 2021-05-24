package com.unla.Grupo09OO22021ABM.converters;

import org.springframework.stereotype.Component;

import com.unla.Grupo09OO22021ABM.entities.Usuario;
import com.unla.Grupo09OO22021ABM.models.UsuarioModel;

@Component("usuarioConverter")
public class UsuarioConverter {
	
	public UsuarioModel entityToModel(Usuario usuario) {
		return new UsuarioModel(usuario.getId_usuario(), usuario.getNombre(), usuario.getApellido(), usuario.getTipo_dni(), usuario.getDni(), usuario.getEmail(), usuario.getUsername(), usuario.getPassword());
	}
	
	public Usuario modelToEntity(UsuarioModel usuarioModel) {
		return new Usuario(usuarioModel.getNombre(), usuarioModel.getApellido(), usuarioModel.getTipo_dni(), usuarioModel.getDni(), usuarioModel.getEmail(), usuarioModel.getUsername(), usuarioModel.getPassword());
	}

}
