package com.unla.Grupo09OO22021.converters;

import org.springframework.stereotype.Component;

import com.unla.Grupo09OO22021.entities.Person;
import com.unla.Grupo09OO22021.models.PersonModel;

@Component("personConverter")
public class PersonConverter {

	public PersonModel entityToModel(Person person) {
		return new PersonModel(person.getId(), person.getName(), person.getBirthdate());
	}

	public Person modelToEntity(PersonModel personModel) {
		return new Person(personModel.getId(), personModel.getName(), personModel.getBirthdate());
	}
}

