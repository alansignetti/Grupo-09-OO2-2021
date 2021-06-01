package com.unla.Grupo09OO22021ABM.services;

import java.util.List;
import java.util.Optional;

import com.unla.Grupo09OO22021ABM.entities.Permiso;

public interface IPermisoService {
	public List<Permiso> listar();
	public Optional<Permiso> listarId(int id);
	public int save(Permiso p);

}
