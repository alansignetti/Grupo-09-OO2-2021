package com.unla.Grupo09OO22021ABM.services.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.Grupo09OO22021ABM.converters.PermisoConverter;
import com.unla.Grupo09OO22021ABM.entities.Permiso;
import com.unla.Grupo09OO22021ABM.repositories.IPermisoRepository;
import com.unla.Grupo09OO22021ABM.services.IPermisoService;

@Service("permisoService")
public class PermisoService implements IPermisoService{
	
	@Autowired
	@Qualifier("permisoRepository")
	private IPermisoRepository permisoRepository;
	
	@Autowired
	@Qualifier("permisoConverter")
	private PermisoConverter permisoConverter;

	@Override
	public List<Permiso> listar() {
		return (List<Permiso>)permisoRepository.findAll();
	}

	@Override
	public Optional<Permiso> listarId(int id) {
		return permisoRepository.findById(id);
	}

	@Override
	public int save(Permiso p) {
		int res=0;
		Permiso permiso = permisoRepository.save(p);
		if (!permiso.equals(null)) {
			res =1;
		}
		return res;
	}

}
