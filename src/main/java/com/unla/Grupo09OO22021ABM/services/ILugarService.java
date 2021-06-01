package com.unla.Grupo09OO22021ABM.services;

import java.util.List;
import java.util.Optional;

import com.unla.Grupo09OO22021ABM.entities.Lugar;

public interface ILugarService {
	
	public List<Lugar> listarLugar();
	public Optional<Lugar> listarId(int id);
	public int save(Lugar l);

}
