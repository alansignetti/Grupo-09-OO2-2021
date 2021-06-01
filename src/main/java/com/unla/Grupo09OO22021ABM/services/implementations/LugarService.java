package com.unla.Grupo09OO22021ABM.services.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Service;

import com.unla.Grupo09OO22021ABM.converters.LugarConverter;
import com.unla.Grupo09OO22021ABM.entities.Lugar;

import com.unla.Grupo09OO22021ABM.repositories.ILugarRepository;
import com.unla.Grupo09OO22021ABM.services.ILugarService;

@Service("lugarService")
public class LugarService implements ILugarService{
	
	@Autowired
	@Qualifier("lugarRepository")
	private ILugarRepository lugarRepository;
	
	@Autowired
	@Qualifier("lugarConverter")
	private LugarConverter lugarConverter;

	@Override
	public List<Lugar> listarLugar() {
		return (List<Lugar>)lugarRepository.findAll();
	}

	@Override
	public Optional<Lugar> listarId(int id) {
		return lugarRepository.findById(id);
	}

	@Override
	public int save(Lugar l) {
		int res=0;
		Lugar lugar = lugarRepository.save(l);
		if (!lugar.equals(null)) {
			res =1;
		}
		return res;
	}

}
