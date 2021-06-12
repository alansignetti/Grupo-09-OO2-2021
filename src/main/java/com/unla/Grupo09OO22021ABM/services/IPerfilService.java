package com.unla.Grupo09OO22021ABM.services;

import java.util.List;
import java.util.Optional;

import com.unla.Grupo09OO22021ABM.entities.Perfil;

public interface IPerfilService {
	
	public List<Perfil> listar();
	public Optional<Perfil> listarId(int id);
	public int save(Perfil p);
	public void delete (int id);
	public boolean validaTipoPerfil(String tipo_perfil);
	public Perfil traerPorId(int id);

}
