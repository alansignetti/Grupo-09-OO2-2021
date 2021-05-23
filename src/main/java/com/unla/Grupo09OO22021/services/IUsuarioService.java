package com.unla.Grupo09OO22021.services;
import java.util.List;

import com.unla.Grupo09OO22021.entities.Usuario;
import com.unla.Grupo09OO22021.models.UsuarioModel;


public interface IUsuarioService {

	public List<Usuario> getAll();
	
	public UsuarioModel findById(int id);
	
	public UsuarioModel findByName(String name);
	
	public UsuarioModel insertOrUpdate(UsuarioModel personModel);
	
	public boolean remove(int id);
	
	public List<UsuarioModel> findByDegreeName(String degreeName);
}

