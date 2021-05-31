package com.unla.Grupo09OO22021ABM.services;

import java.util.List;
import java.util.Optional;

import com.unla.Grupo09OO22021ABM.entities.Usuario;

public interface IUsuarioService {
	
	public List<Usuario> listar();
	public Optional<Usuario> listarId(int id);
	public int save(Usuario u);
	//public DegreeModel insertOrUpdate(DegreeModel degreeModel);
	public void delete (int id);

}
