package com.unla.Grupo09OO22021.services;
import java.util.List;

import com.unla.Grupo09OO22021.entities.Perfil;
import com.unla.Grupo09OO22021.models.PerfilModel;


public interface IPerfilService {

	public List<Perfil> getAll();
	
	public PerfilModel insertOrUpdate(PerfilModel degreeModel);
	
	public boolean remove(int id);
}

