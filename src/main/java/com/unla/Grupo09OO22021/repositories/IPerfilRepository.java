package com.unla.Grupo09OO22021.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.Grupo09OO22021.entities.Perfil;

@Repository("perfilRepository")
public interface IPerfilRepository extends JpaRepository<Perfil, Serializable> {

//	public abstract Perfil findByName(String name);
	
//	@Query("SELECT u FROM Perfil u WHERE u.idPerfil = (:idPerfil)")
//	public abstract Perfil findByIdPerfil(@Param("idPerfil") String idPerfil);
	
	public abstract Perfil findByPerfil(@Param("tipoPerfil") String tipoPerfil);

	public abstract Perfil findById(@Param("id") int id);
	
}
