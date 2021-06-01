package com.unla.Grupo09OO22021ABM.services.implementations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.unla.Grupo09OO22021ABM.converters.UsuarioConverter;
import com.unla.Grupo09OO22021ABM.entities.Usuario;
import com.unla.Grupo09OO22021ABM.repositories.IUsuarioRepository;
import com.unla.Grupo09OO22021ABM.services.IUsuarioService;

@Service("usuarioService")
public class UsuarioService implements IUsuarioService{
	
	@Autowired
	@Qualifier("usuarioRepository")
	private IUsuarioRepository usuarioRepository;
	
	@Autowired
	@Qualifier("usuarioConverter")
	private UsuarioConverter usuarioConverter;

	@Override
	public List<Usuario> listar() {
		return (List<Usuario>)usuarioRepository.findAll();
	}

	@Override
	public Optional<Usuario> listarId(int id) {
		return usuarioRepository.findById(id);
	}

	@Override
	public int save(Usuario u) {
		int res=0;
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		u.setPassword(pe.encode(u.getPassword()));
		Usuario usuario = usuarioRepository.save(u);
		if (!usuario.equals(null)) {
			res =1;
		}
		return res;
	}

	@Override
	public void delete(int id) {
		usuarioRepository.deleteById(id);
	}

}
