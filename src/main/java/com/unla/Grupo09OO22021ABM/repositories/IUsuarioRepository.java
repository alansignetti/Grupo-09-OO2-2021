package com.unla.Grupo09OO22021ABM.repositories;

import java.io.Serializable;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import com.unla.Grupo09OO22021ABM.entities.Usuario;

@Repository("usuarioRepository")
public interface IUsuarioRepository extends JpaRepository<Usuario, Serializable> {

}

