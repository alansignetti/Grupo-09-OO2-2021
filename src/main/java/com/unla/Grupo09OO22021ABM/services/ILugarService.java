package com.unla.Grupo09OO22021ABM.services;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.unla.Grupo09OO22021ABM.entities.Lugar;
import com.unla.Grupo09OO22021ABM.models.LugarModel;

public interface ILugarService {
	
	public List<Lugar> listarLugar();
	public Set<Lugar> listarLugares();
	public Optional<Lugar> listarId(int id);
	public int save(Lugar l);
	public Lugar traerLugar(int id);

}
