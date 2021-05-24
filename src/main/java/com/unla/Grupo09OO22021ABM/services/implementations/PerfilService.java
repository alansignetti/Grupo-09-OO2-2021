package com.unla.Grupo09OO22021ABM.services.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.Grupo09OO22021ABM.converters.PerfilConverter;
import com.unla.Grupo09OO22021ABM.entities.Perfil;
import com.unla.Grupo09OO22021ABM.repositories.IPerfilRepository;
import com.unla.Grupo09OO22021ABM.services.IPerfilService;

@Service("perfilService")
public class PerfilService implements IPerfilService{

	@Autowired
	@Qualifier("perfilRepository")
	private IPerfilRepository perfilRepository;
	
	@Autowired
	@Qualifier("perfilConverter")
	private PerfilConverter perfilConverter;
	
	@Override
	public List<Perfil> listar() {
		return (List<Perfil>)perfilRepository.findAll();
	}

	@Override
	public Optional<Perfil> listarId(int id) {
		return perfilRepository.findById(id);
	}

	@Override
	public int save(Perfil p) {
		int res=0;
		Perfil perfil = perfilRepository.save(p);
		if (!perfil.equals(null)) {
			res =1;
		}
		return res;
	}

	@Override
	public void delete(int id) {
		perfilRepository.deleteById(id);
		
	}

}
