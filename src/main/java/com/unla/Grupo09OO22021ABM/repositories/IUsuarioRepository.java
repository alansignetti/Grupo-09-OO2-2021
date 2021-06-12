package com.unla.Grupo09OO22021ABM.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.Grupo09OO22021ABM.entities.Usuario;

@Repository("usuarioRepository")
public interface IUsuarioRepository extends JpaRepository<Usuario, Serializable> {
	
	@Query("SELECT u FROM Usuario u JOIN FETCH u.perfil WHERE u.username = (:username)")
	public abstract Usuario findByUsernameAndFetchPerfilEagerly(@Param("username") String username);
	
	@Query("SELECT u FROM Usuario u WHERE u.dni = (:dni)")
	public abstract Usuario findByDni(@Param("dni") long dni);
	
	@Query("SELECT u FROM Usuario u WHERE u.email = (:email)")
	public abstract Usuario findByEmail(@Param("email") String email);
	
	@Query("SELECT u FROM Usuario u WHERE u.username = (:username)")
	public abstract Usuario findByUsername(@Param("username") String username);
	
	@Query("SELECT u FROM Usuario u WHERE u.id_usuario = (:id_usuario)")
	public abstract Usuario traerPorId(@Param("id_usuario") int id_usuario);
	
	

}
