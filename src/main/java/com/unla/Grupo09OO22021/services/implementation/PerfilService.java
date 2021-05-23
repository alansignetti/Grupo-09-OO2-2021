package com.unla.Grupo09OO22021.services.implementation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.perfildetails.Perfil;
import org.springframework.security.core.perfildetails.PerfilDetails;
import org.springframework.security.core.perfildetails.PerfilDetailsService;
import org.springframework.security.core.perfildetails.PerfilnameNotFoundException;
import org.springframework.stereotype.Service;

import com.unla.Grupo09OO22021.entities.PerfilRole;
import com.unla.Grupo09OO22021.repositories.IPerfilRepository;

@Service("perfilService")
public class PerfilService implements PerfilDetailsService {

	@Autowired
	@Qualifier("perfilRepository")
	private IPerfilRepository perfilRepository;
	
	@Override
	public PerfilDetails loadPerfilByPerfilname(String perfilname) throws PerfilnameNotFoundException {
		com.unla.Grupo09OO22021.entities.Perfil perfil = perfilRepository.findByPerfilnameAndFetchPerfilRolesEagerly(perfilname);
		return buildPerfil(perfil, buildGrantedAuthorities(perfil.getPerfilRoles()));
	}
	
	private Perfil buildPerfil(com.unla.Grupo09OO22021.entities.Perfil perfil, List<GrantedAuthority> grantedAuthorities) {
		return new Perfil(perfil.getPerfilname(), perfil.getPassword(), perfil.isEnabled(),
						true, true, true, //accountNonExpired, credentialsNonExpired, accountNonLocked,
						grantedAuthorities);
	}
	
	private List<GrantedAuthority> buildGrantedAuthorities(Set<PerfilRole> perfils) {
		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
		for(PerfilRole perfil: perfils) {
			grantedAuthorities.add(new SimpleGrantedAuthority(perfil.getRole()));
		}
		return new ArrayList<GrantedAuthority>(grantedAuthorities);
	}
}
