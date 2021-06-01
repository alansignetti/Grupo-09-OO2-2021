package com.unla.Grupo09OO22021ABM.services;

import java.util.List;
import java.util.Optional;

import com.unla.Grupo09OO22021ABM.entities.Rodado;

public interface IRodadoService {
	
	public List<Rodado> listar();
	public Optional<Rodado> listarId(int id);
	public int save(Rodado r);

}
