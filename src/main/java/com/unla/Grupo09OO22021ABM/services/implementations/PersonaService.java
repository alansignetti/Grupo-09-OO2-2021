package com.unla.Grupo09OO22021ABM.services.implementations;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.Grupo09OO22021ABM.converters.PersonaConverter;
import com.unla.Grupo09OO22021ABM.entities.Persona;
import com.unla.Grupo09OO22021ABM.repositories.IPersonaRepository;
import com.unla.Grupo09OO22021ABM.services.IPersonaService;

@Service("personaService")
public class PersonaService implements IPersonaService{
    
    @Autowired
    @Qualifier("personaConverter")
    private PersonaConverter personaConverter;

    @Autowired
    @Qualifier("personaRepository")
    private IPersonaRepository personaRepository;
    
    @Override
    public List<Persona> listarPersonas() {
		return (List<Persona>)personaRepository.findAll();
	}

//    @Override
//    public PersonaModel altaPersona(PersonaModel persona){
//        return personaConverter.entityToModel(personaRepository.save(personaConverter.modelToEntity(persona)));
//    }
//    
	
	@Override
	public int save(Persona p) {
		int res=0;
		Persona usuario = personaRepository.save(p);
		if (!usuario.equals(null)) {
			res =1;
		}
		return res;
	}
	

	
	@Override
	public Optional<Persona> listarId(int id) {
		return personaRepository.findById(id);
	}

	

	@Override
	public void delete(int id) {
		personaRepository.deleteById(id);
	}

}