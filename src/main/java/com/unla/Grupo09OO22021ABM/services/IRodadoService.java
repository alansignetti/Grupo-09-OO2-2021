package com.unla.Grupo09OO22021ABM.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.unla.Grupo09OO22021ABM.entities.Rodado;

public interface IRodadoService {
	
	public List<Rodado> listar();
	public Optional<Rodado> listarId(int id);
	public int save(Rodado r);
	public Rodado findByDominio(@Param("dominio") String dominio);
	public boolean validarRodado(String dominio);
	public  Rodado traerRodadoId(int id_rodado);
	
}
