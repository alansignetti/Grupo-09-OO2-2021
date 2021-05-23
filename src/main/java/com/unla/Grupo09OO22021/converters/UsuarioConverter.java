package com.unla.Grupo09OO22021.converters;

import org.springframework.stereotype.Component;

import com.unla.Grupo09OO22021.entities.Usuario;
import com.unla.Grupo09OO22021.models.UsuarioModel;

@Component("usuarioConverter")
public class UsuarioConverter {

	public UsuarioModel entityToModel(Usuario usuario) {
		return new UsuarioModel(usuario.getIdUsuario(), usuario.getUsername(), usuario.getPassword(),null);
	}

	public Usuario modelToEntity(UsuarioModel usuarioModel) {
		return new Usuario(usuarioModel.getIdUsuario(), usuarioModel.getUsername(), usuarioModel.getPassword());
	}
}

