package com.unla.Grupo09OO22021ABM.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.Grupo09OO22021ABM.entities.Permiso;

@Repository("permisoRepository")
public interface IPermisoRepository extends JpaRepository<Permiso, Serializable>{
	@Query("SELECT p FROM Permiso p INNER JOIN FETCH p.pedido pr WHERE pr.id_persona = (:id_persona)")
	public abstract List<Permiso> findByIdAndFetchPersonaEagerly(@Param("id_persona") int id_persona);
	
	@Query("SELECT p FROM Permiso p INNER JOIN FETCH p.desdeHasta d WHERE d.idLugar = (:idLugar)")
	public abstract List<Permiso> findByIdAndFetchLugarEagerly(@Param("idLugar") int idLugar);
}
