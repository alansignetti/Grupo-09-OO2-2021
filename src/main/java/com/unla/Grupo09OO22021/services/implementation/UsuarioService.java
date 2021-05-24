package com.unla.Grupo09OO22021.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.Grupo09OO22021.repositories.IUsuarioRepository;
import com.unla.Grupo09OO22021.services.IUsuarioService;
import com.unla.Grupo09OO22021.entities.Usuario;
import com.unla.Grupo09OO22021.converters.UsuarioConverter;
import com.unla.Grupo09OO22021.models.UsuarioModel;

@Service("usuarioService")
public class UsuarioService implements IUsuarioService {

	@Autowired
	@Qualifier("usuarioRepository")
	private IUsuarioRepository usuarioRepository;
	
	@Autowired
	@Qualifier("usuarioModel")
	private UsuarioConverter usuarioModel;
	
	

	public void altaUsuario(UsuarioModel usuario) throws Exception {
		try {
			Usuario user = usuarioModel.modelToEntity(usuario);
			usuarioRepository.save(user);
		} catch (Exception e) {
			throw new Exception("Ha ocurrido un error");
		}
	}

	@Override
	public List<Usuario> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Usuario findByUsername(String usuario) {
		return usuarioRepository.findByUsername(usuario);
	}


	@Override
	public Usuario findById(int id) {
		return usuarioRepository.findById(id);
	}

	@Override
	public void bajaUsuario(int id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificacionUsuario(UsuarioModel usuarioModel) throws Exception {
		// TODO Auto-generated method stub
		
	}

	


}
