package com.unla.Grupo09OO22021ABM.converters;

import org.springframework.stereotype.Component;

import com.unla.Grupo09OO22021ABM.entities.Persona;
import com.unla.Grupo09OO22021ABM.models.PersonaModel;

@Component("personaConverter")
public class PersonaConverter {
	
	
	
	public Persona modelToEntity(PersonaModel personaModel) {
		return new Persona(personaModel.getNombre(), personaModel.getApellido(),
				personaModel.getDni());
	}


	public PersonaModel entityToModel(Persona persona) {
		return new PersonaModel(persona.getIdPersona(), persona.getNombre(), persona.getApellido(), persona.getDni());
	}

	
}


