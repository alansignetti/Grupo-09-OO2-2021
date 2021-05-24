package com.unla.Grupo09OO22021.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.Grupo09OO22021.converters.PerfilConverter;
import com.unla.Grupo09OO22021.entities.Perfil;
import com.unla.Grupo09OO22021.models.PerfilModel;
import com.unla.Grupo09OO22021.repositories.IPerfilRepository;
import com.unla.Grupo09OO22021.services.IPerfilService;


@Service("perfilService")
public class PerfilService implements IPerfilService {

	@Autowired
	@Qualifier("perfilRepository")
	private IPerfilRepository perfilRepository;

	@Autowired
	@Qualifier("perfilModel")
	private PerfilConverter perfilModel;

	public Perfil findByTipoPerfil(String tipoPerfil) {
		return perfilRepository.findByTipoPerfil(tipoPerfil);
	}

	public Perfil findById(int id) {
		return perfilRepository.findById(id);
	}
	public PerfilModel traerPerfil(int id) {

		return perfilModel.entityToModel(perfilRepository.findById(id));
	}

	
	public void altaPerfil(PerfilModel perfil) throws Exception {
		try {
			Perfil rol = perfilModel.modelToEntity(perfil);
			perfilRepository.save(rol);
		} catch (Exception e) {
			throw new Exception("No se pudo completar la operación,error al ingresar los datos o el usuario ya existe");
		}
	}

	public void bajaPerfil(int id) throws Exception {
		Perfil perfil = perfilRepository.findById(id);
		try {
			perfilRepository.delete(perfil);
		} catch (Exception e) {
			throw new Exception("No se pudo completar la operación");
		}
	}

	public void modificacionPerfil(PerfilModel perfil) throws Exception {
		try {
			perfilRepository.saveAndFlush(perfilModel.modelToEntity(perfil));
		} catch (Exception e) {
			throw new Exception("No se pudo completar la operación");
		}
	}

	public List<Perfil> findAll() {

		return perfilRepository.findAll();
	}

	@Override
	public List<Perfil> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PerfilModel insertOrUpdate(PerfilModel perfilModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(int id) {
		// TODO Auto-generated method stub
		return false;
	}
}
