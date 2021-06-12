package com.unla.Grupo09OO22021ABM.services.implementations;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.unla.Grupo09OO22021ABM.repositories.IUsuarioRepository;
import com.unla.Grupo09OO22021ABM.services.IPerfilService;

@Service
public class UserDetailsServiceSecurity implements UserDetailsService {

	@Autowired
	IUsuarioRepository usuarioRepository;

	@Autowired
	IPerfilService perfilRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.unla.Grupo09OO22021ABM.entities.Usuario appUser = usuarioRepository
				.findByUsernameAndFetchPerfilEagerly(username);

		List grantList = new ArrayList();

		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(appUser.getPerfil().getTipo_perfil());
		grantList.add(grantedAuthority);

		UserDetails user = (UserDetails) new User(appUser.getUsername(), appUser.getPassword(), grantList);
		return user;
	}
}