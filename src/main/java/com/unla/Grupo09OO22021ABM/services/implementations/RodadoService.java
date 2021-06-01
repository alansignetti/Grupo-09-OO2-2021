package com.unla.Grupo09OO22021ABM.services.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import com.unla.Grupo09OO22021ABM.entities.Rodado;

import com.unla.Grupo09OO22021ABM.repositories.IRodadoRepository;
import com.unla.Grupo09OO22021ABM.services.IRodadoService;

@Service("rodadoService")
public class RodadoService implements IRodadoService{
	
	@Autowired
	@Qualifier("rodadoRepository")
	private IRodadoRepository rodadoRepository;

	@Override
	public List<Rodado> listar() {
		return (List<Rodado>)rodadoRepository.findAll();
	}

	@Override
	public Optional<Rodado> listarId(int id) {
		return rodadoRepository.findById(id);
	}

	@Override
	public int save(Rodado r) {
		int res=0;
		Rodado rodado = rodadoRepository.save(r);
		if (!rodado.equals(null)) {
			res =1;
		}
		return res;
	}

}
