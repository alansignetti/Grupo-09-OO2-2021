package com.unla.Grupo09OO22021ABM.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.unla.Grupo09OO22021ABM.entities.Permiso;
import com.unla.Grupo09OO22021ABM.entities.PermisoDiario;
import com.unla.Grupo09OO22021ABM.entities.PermisoPeriodo;

public interface IPermisoService {
	
	public List<Permiso> listar();
	public Optional<Permiso> listarId(int id);
	public int save(Permiso p);
	Permiso traerPermisoId(int id);
	
	public List<PermisoDiario> listarPermisosDiario(List<Permiso> listaPermisos);	
	public List<PermisoPeriodo> listarPermisosPeriodo(List<Permiso> listaPermisos);	
	public List<PermisoPeriodo> listarFechaPermisoPeriodo(List<PermisoPeriodo> listaPermisosPeriodo,LocalDate fecha1,LocalDate fecha2);	
	public List<PermisoDiario> listarFechaPermisoDiario(List<PermisoDiario> listaPermisos,LocalDate fecha);	
	public List<Permiso> findByIdAndFetchPersonaEagerly(int id_persona);	
	public List<Permiso> findByIdAndFetchLugarEagerly(int idLugar);
	
	
	
}
