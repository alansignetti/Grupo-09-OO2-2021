package com.unla.Grupo09OO22021ABM.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.unla.Grupo09OO22021ABM.services.implementations.UserDetailsServiceSecurity;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{


	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()

				
				.antMatchers("/css/*", "/imgs/*", "/js/*", "/vendor/bootstrap/css/*", "/vendor/jquery/*", "/vendor/bootstrap/js/*","/home*","/static/**","/static/home/*","/home/**").permitAll()


				.antMatchers("/css/*", "/imgs/*", "/js/*", "/vendor/bootstrap/css/*", "/vendor/jquery/*", "/vendor/bootstrap/js/*","/home","/static*").permitAll()
				
				// hasAnyRole('AUDITOR', 'ADMIN')
				.antMatchers("/new").access("hasRole('ADMIN')")
				.antMatchers("/new-perfil").access("hasRole('ADMIN')")
		        .antMatchers("/listar-perfiles").access("hasAnyRole('AUDITOR', 'ADMIN')")   
		        .antMatchers("/listar").access("hasAnyRole('AUDITOR', 'ADMIN')") 
		        .antMatchers("/new-persona").access("anonymous")
		        .antMatchers("/new-permiso-diario").access("anonymous")
		        .antMatchers("/new-permiso-periodo").access("anonymous")
		        .antMatchers("/new-rodado").access("anonymous")
		        
		        
		        
		        .antMatchers("/index").access("hasRole('ADMIN')")
		        .antMatchers("/index-perfil").access("hasRole('ADMIN')")
		        				// lista usuarios
		        .antMatchers("/listar/?format=pdf").access("hasRole('AUDITOR')")	// ExportPDF
		        
		        .antMatchers("/listar-personas").access("hasRole('ADMIN')")  
		        .antMatchers("/editar-persona").access("hasRole('ADMIN')")
		        .antMatchers("/eliminar-persona").access("hasRole('ADMIN')")
		        .antMatchers("/editar-persona/**").access("hasRole('ADMIN')")
		        .antMatchers("/eliminar-persona/**").access("hasRole('ADMIN')")
		        
		        .antMatchers("/eliminar-perfil").access("hasRole('ADMIN')")
		        .antMatchers("/editar-perfil").access("hasRole('ADMIN')")
		        .antMatchers("/eliminar-perfil/**").access("hasRole('ADMIN')")
		        .antMatchers("/editar-perfil/**").access("hasRole('ADMIN')")
		        .antMatchers("/permiso-persona").access("hasRole('AUDITOR') or anonymous")
		        
		        
		        .antMatchers("/permiso-entre-fechas-origen").access("hasRole('AUDITOR')")	
		        .antMatchers("/permisos-fecha-origen").access("hasRole('AUDITOR')")	
		        .antMatchers("/permiso-entre-fechas-destino").access("hasRole('AUDITOR')")	
		        .antMatchers("/permisos-fecha-destino").access("hasRole('AUDITOR')")	
		        .antMatchers("/permisos-fecha").access("hasRole('AUDITOR')")	
		        .antMatchers("/permiso-entre-fechas").access("hasRole('AUDITOR')")
		        .antMatchers("/BuscarPermisoPeriodoRodado").access("hasRole('AUDITOR')")
		        
		        
		        
		        
		        .antMatchers("/listar-personas").permitAll()	
		        .antMatchers("/home").permitAll()    
		        
		        

			.and()
				.formLogin().loginPage("/login").loginProcessingUrl("/loginprocess").defaultSuccessUrl("/home")
				.usernameParameter("username").passwordParameter("password")
				.permitAll()
				
				
			.and()
			//Con esta instruccion el Logout se hace correctamente
			.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login");
		
				/*.logout().logoutUrl("/logout").logoutSuccessUrl("/logout").disable().anonymous().
				.clearAuthentication(true).invalidateHttpSession(true)
				.deleteCookies("JSESSIONID").permitAll();*/
				
				
		
	}
	
    BCryptPasswordEncoder bCryptPasswordEncoder;
	
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
		bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
        return bCryptPasswordEncoder;
    }
	
    @Autowired
    UserDetailsServiceSecurity userDetailsService;
	
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception { 
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());     
    }

}
