package com.unla.Grupo09OO22021ABM.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.Grupo09OO22021ABM.entities.Rodado;

@Repository("rodadoRepository")
public interface IRodadoRepository extends JpaRepository<Rodado, Serializable>{

	@Query("SELECT r FROM Rodado r WHERE r.dominio = (:dominio)")
	public abstract Rodado findByDominio(@Param("dominio") String dominio);
	
	@Query("SELECT r FROM Rodado r WHERE r.id_rodado = (:id_rodado)")
	public abstract Rodado traerRodadoId(int id_rodado);
	
	
	
}
