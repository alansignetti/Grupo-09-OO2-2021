package com.unla.Grupo09OO22021ABM.converters;

import org.springframework.stereotype.Component;

import com.unla.Grupo09OO22021ABM.entities.Persona;
import com.unla.Grupo09OO22021ABM.models.PersonaModel;

@Component("personaConverter")
public class PersonaConverter {
	
	
	public PersonaModel entityToModel(Persona persona) {
		return new PersonaModel(persona.getId_persona(), persona.getNombre(), persona.getApellido(), persona.getDni());
	}

	public Persona modelToEntity(PersonaModel personaModel) {
		return new Persona( personaModel.getNombre(), personaModel.getApellido(),
				personaModel.getDni());
	}


	
	
}


