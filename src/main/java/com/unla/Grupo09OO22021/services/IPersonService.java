package com.unla.Grupo09OO22021.services;
import java.util.List;

import com.unla.Grupo09OO22021.entities.Person;
import com.unla.Grupo09OO22021.models.PersonModel;


public interface IPersonService {

	public List<Person> getAll();
	
	public PersonModel findById(int id);
	
	public PersonModel findByName(String name);
	
	public PersonModel insertOrUpdate(PersonModel personModel);
	
	public boolean remove(int id);
	
	public List<PersonModel> findByDegreeName(String degreeName);
}

