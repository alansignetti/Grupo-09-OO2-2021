package com.unla.Grupo09OO22021ABM.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.unla.Grupo09OO22021ABM.entities.Persona;

public interface IPersonaService {
    
    public int save(Persona p);    
    public List<Persona> listarPersonas();
	public Optional<Persona> listarIdPersona(int id);
	public void delete(int id);
	public Persona findByDni(long dni);
	public Persona traerPorDni(@Param("dni") long dni);
}