//package com.unla.Grupo09OO22021ABM.converters;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Component;
//
//import com.unla.Grupo09OO22021ABM.entities.Lugar;
//import com.unla.Grupo09OO22021ABM.entities.Permiso;
//import com.unla.Grupo09OO22021ABM.models.LugarModel;
//import com.unla.Grupo09OO22021ABM.models.PermisoModel;
//
//@Component("permisoConveter")
//public class PermisoConverter {
//	
//	@Autowired
//	@Qualifier("personaConverter")
//	private PersonaConverter personaConverter;
//
//	@Autowired
//	@Qualifier("lugarConverter")
//	private LugarConverter lugarConverter;
//	
//	
//	
//	public PermisoModel entityToModel(Permiso permiso) {
//		Set<LugarModel> desdeHasta = new HashSet<>();
//		
//			for(Lugar lugar : permiso.getDesdeHasta()){
//				desdeHasta.add(lugarConverter.entityToModel(lugar));
//			}
//	
//		return new PermisoModel(permiso.getIdPermiso(),personaConverter.entityToModel(permiso.getPedido()),permiso.getFecha(),desdeHasta);	
//	}
//	
//	public Permiso modelToEntity(PermisoModel permisoModel) {
//		Set<Lugar> desdeHasta = new HashSet<>();
//			for(LugarModel lugarModel : permisoModel.getDesdeHasta()){
//				desdeHasta.add(lugarConverter.modelToEntity(lugarModel));
//			}
//		return new Permiso(permisoModel.getIdPermiso(),personaConverter.modelToEntity(permisoModel.getPedido()),
//							permisoModel.getFecha(),desdeHasta);				
//	}
//	
//	
//	
//	
//
//}