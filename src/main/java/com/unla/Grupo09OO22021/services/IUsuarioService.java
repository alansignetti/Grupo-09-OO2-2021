package com.unla.Grupo09OO22021.services;
import java.util.List;



import com.unla.Grupo09OO22021.entities.Usuario;
import com.unla.Grupo09OO22021.models.UsuarioModel;


public interface IUsuarioService {

	public List<Usuario> getAll();
	
	Usuario findByUsername(String usuarioModel);

	Usuario findById(int id);
	

	void altaUsuario(UsuarioModel usuarioModel) throws Exception;

	void bajaUsuario(int id) throws Exception;

	void modificacionUsuario(UsuarioModel usuarioModel) throws Exception;
	
}

