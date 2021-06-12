package com.unla.Grupo09OO22021ABM.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.Grupo09OO22021ABM.entities.PermisoPeriodo;

@Repository("permisoPeriodoRepository")
public interface IPermisoPeriodoRepository extends JpaRepository<PermisoPeriodo, Serializable>{
	
	@Query("SELECT p FROM PermisoPeriodo p INNER JOIN FETCH p.rodado r WHERE r.id_rodado = (:id_rodado)")
	public abstract List<PermisoPeriodo> findByIdAndFetchRodadoEagerly(@Param("id_rodado") int  id_rodado);

}
