package com.unla.Grupo09OO22021ABM.repositories;


import java.util.Optional;
import com.unla.Grupo09OO22021ABM.entities.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IUserRepositorySecurity extends CrudRepository<Usuario, Long>  {
    public Optional<Usuario> findByUsername(String username);
}