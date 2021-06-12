package com.unla.Grupo09OO22021ABM.repositories;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.Grupo09OO22021ABM.entities.Perfil;

@Repository("perfilRepository")
public interface IPerfilRepository extends JpaRepository<Perfil, Serializable>{
	
	@Query("SELECT p FROM Perfil p WHERE p.id_perfil = (:id_perfil)")
	public abstract Perfil traerPorId(@Param("id_perfil") int id_perfil);
	
	@Query("SELECT p FROM Perfil p WHERE p.tipo_perfil = (:tipo_perfil)")
	public abstract Perfil traerPorTipoPerfil(@Param("tipo_perfil") String tipo_perfil);

}
