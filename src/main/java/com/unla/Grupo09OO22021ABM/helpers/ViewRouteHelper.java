package com.unla.Grupo09OO22021ABM.helpers;

import org.springframework.web.servlet.view.RedirectView;

@SuppressWarnings("unused")
public class ViewRouteHelper {
 
	/**** Views ****/
	
	
	//USUARIO
	public final static String INDEX = "/index";
	public final static String FORM_USUARIO = "/form";
	
	//PERFIL
	public final static String INDEX_PERFIL = "/index-perfil";
	public final static String FORM_PERFIL = "/form-perfil"; // return ViewRouteHelper.FORMPERFIL;
	
	//USER
	public final static String USER_LOGIN = "user/login";
	public final static String USER_LOGOUT = "user/logout";
	
	//PERSONA
	public final static String FORM_PERSONA = "/form-persona";
	public final static String INDEX_PERSONA = "/index-persona";
	public final static String PERSONA_DNI = "/persona-dni";
	
	//PERMISO DIARIO
	public final static String FORM_PERMISO_DIARIO = "/form-permiso-diario";
	public final static String LISTA_PERMISO_DIARIO = "/lista-permiso-diario";
	
	//PERMISO PERIODO
	public final static String FORM_PERMISO_PERIODO = "/form-permiso-periodo";
	public final static String LISTA_PERMISO_PERIODO = "/lista-permiso-periodo";
	
	//RODADO
	public final static String FORM_RODADO = "/form-rodado";
	public final static String INDEX_RODADO = "/index-rodado";
	public final static String PERMISO_PERIODO_POR_RODADO = "/BuscarPermisoPeriodoRodado";
	public final static String LISTADO_PERMISO_RODADO = "/ListadoPermisoPeriodoRodado";
	
	
	
	//TRAER PERMISOS
	public final static String PERMISO_PERSONA = "/permiso-persona";
	public final static String RESULTADO_ENTRE_FECHAS = "/permiso/resultado-entre-fechas";
	public final static String PERMISO_ENTRE_FECHAS = "/permiso/entre-fechas";
	public final static String PERMISO_ENTRE_FECHAS_ORIGEN = "/permiso/entre-fechas-origen";
	public final static String RESULTADO_ENTRE_FECHAS_ORIGEN = "/permiso/resultado-entre-fechas-origen";
	public final static String PERMISO_ENTRE_FECHAS_DESTINO = "/permiso/entre-fechas-destino";
	public final static String RESULTADO_ENTRE_FECHAS_DESTINO = "/permiso/resultado-entre-fechas-destino";
	
	//QR DE PERMISOS
	public final static String MOSTRAR_QR = "/qrpermiso/qrpermisodiario";
	private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/QRCode.png";
	
	
	/**** Redirects ****/
	public final static String HOME = "/home"; // new RedirectView(ViewRouteHelper.HOME)
	public final static String PERFILES = "/listar-perfiles"; //	new RedirectView(ViewRouteHelper.PERFILES)
	public final static String USUARIOS = "/listar"; 
	public final static String PERSONAS = "/listar-personas"; 
	public final static String PERMISO_DIARIO = "/listar-permiso-diario";
	public final static String PERMISO_PERIODO = "/listar-permiso-periodo";
	public final static String RODADOS = "/listar-rodados";
	public final static String PERMISO_POR_RODADOS = "/BuscarPermisoPeriodoRodado";
	public final static String TRAER_PERSONA_DNI = "/traerPersonaDNI";

}