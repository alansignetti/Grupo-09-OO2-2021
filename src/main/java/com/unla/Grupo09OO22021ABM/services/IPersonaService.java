package com.unla.Grupo09OO22021ABM.services;

import java.util.List;
import java.util.Optional;

import com.unla.Grupo09OO22021ABM.entities.Persona;
import com.unla.Grupo09OO22021ABM.models.PersonaModel;

public interface IPersonaService {
    
//    public PersonaModel altaPersona(PersonaModel persona);
    
    public int save(Persona p);
    
    public List<Persona> listarPersonas();

	public Optional<Persona> listarIdPersona(int id);

	public void delete(int id);
}