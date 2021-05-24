package com.unla.Grupo09OO22021.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.Grupo09OO22021.entities.Usuario;

@Repository("usuarioRepository")
public interface IUsuarioRepository extends JpaRepository<Usuario, Serializable> {

//	@Query("SELECT u FROM Usuario u WHERE u.username = (:username)")
//	public abstract Usuario findByUsername(@Param("username") String username);
//	

	public abstract Usuario findByUsername(@Param("username") String username);
	
	public abstract Usuario findById(@Param("id") int id);

}
