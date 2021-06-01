package com.unla.Grupo09OO22021ABM.services;

import java.util.List;
import java.util.Optional;

import com.unla.Grupo09OO22021ABM.entities.PermisoPeriodo;

public interface IPermisoPeriodoService {
	public List<PermisoPeriodo> listar();
	public Optional<PermisoPeriodo> listarId(int id);
	public int save(PermisoPeriodo pp);

}
