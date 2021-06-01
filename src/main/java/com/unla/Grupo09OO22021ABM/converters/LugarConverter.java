//package com.unla.Grupo09OO22021ABM.converters;
//
//import org.springframework.stereotype.Component;
//
//import com.unla.Grupo09OO22021ABM.entities.Lugar;
//import com.unla.Grupo09OO22021ABM.models.LugarModel;
//
//@Component("lugarConverter")
//public class LugarConverter {
//
//	public LugarModel entityToModel(Lugar lugar) {
//		return new LugarModel(lugar.getIdLugar(), lugar.getLugar(), lugar.getCodigoPostal());
//	}
//	public Lugar modelToEntity(LugarModel lugarModel) {
//		return new Lugar(lugarModel.getIdLugar(), lugarModel.getLugar(), lugarModel.getCodigoPostal());
//	}
//
//	
//}