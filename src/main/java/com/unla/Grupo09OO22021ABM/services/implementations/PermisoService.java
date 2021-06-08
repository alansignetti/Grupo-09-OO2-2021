package com.unla.Grupo09OO22021ABM.services.implementations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.Grupo09OO22021ABM.converters.PermisoConverter;
import com.unla.Grupo09OO22021ABM.entities.Permiso;
import com.unla.Grupo09OO22021ABM.entities.PermisoDiario;
import com.unla.Grupo09OO22021ABM.entities.PermisoPeriodo;
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
	
	@Override
	public Permiso traerPermisoId(int id) {
		return permisoRepository.findById(id).orElse(null);
	}

	@Override
	public List<PermisoDiario> listarPermisosDiario(List<Permiso> listaPermisos) {
List<PermisoDiario> permisosDiario = new ArrayList<PermisoDiario>();
		
		for (Permiso p : listaPermisos) {
			if (p instanceof PermisoDiario) {
				permisosDiario.add((PermisoDiario) p);
			}
		}
		return permisosDiario;	
	}

	@Override
	public List<PermisoPeriodo> listarPermisosPeriodo(List<Permiso> listaPermisos) {
		List<PermisoPeriodo> permisosDiario = new ArrayList<PermisoPeriodo>();
		for (Permiso p : listaPermisos) {
			if (p instanceof PermisoPeriodo) {
				permisosDiario.add((PermisoPeriodo) p);
			}
		}
		return permisosDiario;	
	}

	@Override
	public List<PermisoPeriodo> listarFechaPermisoPeriodo(List<PermisoPeriodo> listaPermisosPeriodo, LocalDate fecha1,
			LocalDate fecha2) {
		List<PermisoPeriodo> permisosPeriodo= new ArrayList<PermisoPeriodo>();
		for (PermisoPeriodo p : listaPermisosPeriodo) {
			LocalDate fechaVencimiento = p.getFecha().plusDays(p.getCantDias());
			if (fecha1.isEqual(p.getFecha()) && fecha2.isBefore(fechaVencimiento)|| fecha1.isAfter(p.getFecha())&&fecha2.isEqual(fechaVencimiento) || fecha1.isAfter(p.getFecha()) && fecha2.isBefore(fechaVencimiento)
					|| fecha1.isEqual(p.getFecha()) && fecha2.isEqual(fechaVencimiento)) {
				permisosPeriodo.add(p);
			}
		}
		System.out.println("SERVICE" + permisosPeriodo);
		return permisosPeriodo;	
	}

	@Override
	public List<PermisoDiario> listarFechaPermisoDiario(List<PermisoDiario> listaPermisos, LocalDate fecha) {
		List<PermisoDiario> permisosDiario = new ArrayList<PermisoDiario>();
		for (PermisoDiario p : listaPermisos) {
			if (p.getFecha().isEqual(fecha)) {
				permisosDiario.add(p);
			}
		}
		return permisosDiario;	
	}

	@Override
	public List<Permiso> findByIdAndFetchPersonaEagerly(int id_persona){
		return permisoRepository.findByIdAndFetchPersonaEagerly(id_persona);
	}
	
	@Override
	public List<Permiso> findByIdAndFetchLugarEagerly(int idLugar){
		return permisoRepository.findByIdAndFetchLugarEagerly(idLugar);
	}
	
	
	

}
