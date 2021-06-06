package com.unla.Grupo09OO22021ABM.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.unla.Grupo09OO22021ABM.entities.PermisoPeriodo;

public interface IPermisoPeriodoService {
	public List<PermisoPeriodo> listar();
	public Optional<PermisoPeriodo> listarId(int id);
	public int save(PermisoPeriodo pp);

	public List<PermisoPeriodo> findByIdAndFetchRodadoEagerly(@Param(" id_rodado") int  id_rodado);

	public PermisoPeriodo traerPemisoId(int id);

}
