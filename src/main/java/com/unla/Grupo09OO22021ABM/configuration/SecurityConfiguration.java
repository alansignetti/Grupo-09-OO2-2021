package com.unla.Grupo09OO22021ABM.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.unla.Grupo09OO22021ABM.services.implementations.UserDetailsServiceSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

 
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/css/*", "/imgs/*", "/js/*", "/vendor/bootstrap/css/*", "/vendor/jquery/*", "/vendor/bootstrap/js/*","/home*").permitAll()
				.antMatchers("/new*").access("hasRole('ADMIN')") 
				.antMatchers("/new-perfil*").access("hasRole('ADMIN')")
				
		        .antMatchers("/listar-perfiles*").access("hasRole('USER') || hasRole('ADMIN')")
		        .antMatchers("/home").permitAll()
		        //Agregar lista de user.
				.anyRequest().authenticated()
			.and()
				.formLogin().loginPage("/login").loginProcessingUrl("/loginprocess")
				.usernameParameter("username").passwordParameter("password")
				.defaultSuccessUrl("/loginsuccess").permitAll()
			.and()
				.logout().logoutUrl("/logout").logoutSuccessUrl("/logout").permitAll();
	}
	
    BCryptPasswordEncoder bCryptPasswordEncoder;
    //Crea el encriptador de contraseñas	
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
		bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
//El numero 4 representa que tan fuerte quieres la encriptacion.
//Se puede en un rango entre 4 y 31. 
//Si no pones un numero el programa utilizara uno aleatoriamente cada vez
//que inicies la aplicacion, por lo cual tus contrasenas encriptadas no funcionaran bien
        return bCryptPasswordEncoder;
    }
	
    @Autowired
    UserDetailsServiceSecurity userDetailsService;
	
    //Registra el service para usuarios y el encriptador de contrasena
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception { 
 
        // Setting Service to find User in the database.
        // And Setting PassswordEncoder
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());     
    }
}

