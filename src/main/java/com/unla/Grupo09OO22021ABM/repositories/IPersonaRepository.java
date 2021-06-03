package com.unla.Grupo09OO22021ABM.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.Grupo09OO22021ABM.entities.Persona;
import com.unla.Grupo09OO22021ABM.entities.Usuario;

@Repository("personaRepository")
public interface IPersonaRepository extends JpaRepository<Persona, Serializable>  {
    
//	@Query("SELECT u FROM Persona u where u.id_persona = (:id_persona)")
//	public abstract Persona findByIdPersona(@Param("id_persona") int id_persona);
}