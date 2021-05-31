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


import com.unla.Grupo09OO22021ABM.entities.Perfil;
import com.unla.Grupo09OO22021ABM.repositories.IUserRepositorySecurity;
import com.unla.Grupo09OO22021ABM.services.IPerfilService;

@Service
public class UserDetailsServiceSecurity implements UserDetailsService {

    @Autowired
    IUserRepositorySecurity userRepository;
    
    @Autowired
    IPerfilService perfilRepository;
	
    @Override
     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
     //Buscar el usuario con el repositorio y si no existe lanzar una exepcion
     com.unla.Grupo09OO22021ABM.entities.Usuario appUser = 
                 userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("No existe usuario"));
		
     
     //List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();     
    //Mapear nuestra lista de Authority con la de spring security 
    List grantList = new ArrayList();
    
    
    
    // ¿EL PROBLEMA ES QUE NO ESTA TRAYENDO EL PERFIL DEL USUARIO //
   // GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(perfil.getTipo_perfil());
    
    //grantList.add(grantedAuthority);
    
    for (Perfil perfil: perfilRepository.listar()) {
        // ROLE_USER, ROLE_ADMIN,..
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(perfil.getTipo_perfil());
            grantList.add(grantedAuthority);
    }
		
    //Crear El objeto UserDetails que va a ir en sesion y retornarlo.
    UserDetails user = (UserDetails) new User(appUser.getUsername(), appUser.getPassword(), grantList);
    return user;
    }
}