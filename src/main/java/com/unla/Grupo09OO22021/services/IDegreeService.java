package com.unla.Grupo09OO22021.services;
import java.util.List;

import com.unla.Grupo09OO22021.entities.Degree;
import com.unla.Grupo09OO22021.models.DegreeModel;


public interface IDegreeService {

	public List<Degree> getAll();
	
	public DegreeModel insertOrUpdate(DegreeModel degreeModel);
	
	public boolean remove(int id);
}

