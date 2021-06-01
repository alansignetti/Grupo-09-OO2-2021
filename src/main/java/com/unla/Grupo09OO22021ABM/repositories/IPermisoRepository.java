package com.unla.Grupo09OO22021ABM.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.Grupo09OO22021ABM.entities.Permiso;

@Repository("permisoRepository")
public interface IPermisoRepository extends JpaRepository<Permiso, Serializable>{

}
