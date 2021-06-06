package com.unla.Grupo09OO22021ABM.services.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import com.unla.Grupo09OO22021ABM.entities.PermisoDiario;
import com.unla.Grupo09OO22021ABM.repositories.IPermisoDiarioRepository;
import com.unla.Grupo09OO22021ABM.services.IPermisoDiarioService;

@Service("permisoDiarioService")
public class PermisoDiarioService implements IPermisoDiarioService{
	
	@Autowired
	@Qualifier("permisoDiarioRepository")
	private IPermisoDiarioRepository permisoDiarioRepository;

	@Override
	public List<PermisoDiario> listar() {
		return (List<PermisoDiario>)permisoDiarioRepository.findAll();
	}

	@Override
	public Optional<PermisoDiario> listarId(int id) {
		return permisoDiarioRepository.findById(id);
	}

	@Override
	public int save(PermisoDiario pd) {
		int res=0;
		PermisoDiario permisoDiario = permisoDiarioRepository.save(pd);
		if (!permisoDiario.equals(null)) {
			res =1;
		}
		return res;
	}

	@Override
	public PermisoDiario traerPermisoId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
