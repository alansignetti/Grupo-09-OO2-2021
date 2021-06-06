package com.unla.Grupo09OO22021ABM.services.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;


import com.unla.Grupo09OO22021ABM.entities.PermisoPeriodo;
import com.unla.Grupo09OO22021ABM.repositories.IPermisoPeriodoRepository;
import com.unla.Grupo09OO22021ABM.services.IPermisoPeriodoService;

@Service("permisoPeriodoService")
public class PermisoPeriodoService implements IPermisoPeriodoService{
	
	@Autowired
	@Qualifier("permisoPeriodoRepository")
	private IPermisoPeriodoRepository permisoPeriodoRepository;

	@Override
	public List<PermisoPeriodo> listar() {
		return (List<PermisoPeriodo>)permisoPeriodoRepository.findAll();
	}

	@Override
	public Optional<PermisoPeriodo> listarId(int id) {
		return permisoPeriodoRepository.findById(id);
	}

	@Override
	public int save(PermisoPeriodo pp) {
		int res=0;
		PermisoPeriodo permisoPeriodo = permisoPeriodoRepository.save(pp);
		if (!permisoPeriodo.equals(null)) {
			res =1;
		}
		return res;
	}

	@Override
	public PermisoPeriodo traerPemisoId(int id) {
		return permisoPeriodoRepository.findById(id).orElse(null);
	}

	public List<PermisoPeriodo> findByIdAndFetchRodadoEagerly(@Param("id_rodado") int id_rodado){
		return permisoPeriodoRepository.findByIdAndFetchRodadoEagerly(id_rodado);
	}


}
