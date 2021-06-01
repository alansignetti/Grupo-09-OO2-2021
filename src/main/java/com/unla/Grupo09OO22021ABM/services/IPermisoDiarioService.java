package com.unla.Grupo09OO22021ABM.services;

import java.util.List;
import java.util.Optional;

import com.unla.Grupo09OO22021ABM.entities.PermisoDiario;

public interface IPermisoDiarioService {
	
	public List<PermisoDiario> listar();
	public Optional<PermisoDiario> listarId(int id);
	public int save(PermisoDiario pd);

}
