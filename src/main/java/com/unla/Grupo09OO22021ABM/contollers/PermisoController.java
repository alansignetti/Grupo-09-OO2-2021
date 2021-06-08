package com.unla.Grupo09OO22021ABM.contollers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.unla.Grupo09OO22021ABM.entities.Permiso;
import com.unla.Grupo09OO22021ABM.entities.PermisoDiario;
import com.unla.Grupo09OO22021ABM.entities.PermisoPeriodo;
import com.unla.Grupo09OO22021ABM.helpers.ViewRouteHelper;
import com.unla.Grupo09OO22021ABM.services.IPermisoService;

@Controller
@RequestMapping
public class PermisoController {
 
	@Autowired
	@Qualifier("permisoService")
	private IPermisoService servicePermiso;
	
	
	@GetMapping("/permiso-entre-fechas")
	public String buscarPorDominio (Model model) {	
		return ViewRouteHelper.PERMISO_ENTRE_FECHAS;
	}
	
	
	@GetMapping("/permisos-fecha")
	public String listarPermisosFecha(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaDesde,  @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaHasta, Model model,RedirectAttributes attribute) {
		
		
		List<PermisoDiario> permisosDiario = new ArrayList<PermisoDiario>();
		List<PermisoPeriodo> permisosPeriodo = new ArrayList<PermisoPeriodo>();
		
		System.out.println("Fecha" + fechaDesde);
		
		permisosPeriodo = servicePermiso.listarFechaPermisoPeriodo(servicePermiso.listarPermisosPeriodo(servicePermiso.listar()), fechaDesde, fechaHasta);
		//permisosDiario = servicePermiso.listarFechaPermisoDiario(servicePermiso.listarPermisosDiario(servicePermiso.listar()),fechaDesde);
		
		//List<PermisoPeriodo> permisos = servicePermiso.listarPermisosPeriodo(servicePermiso.listar());
		//List<PermisoDiario> permisosDiario2 = servicePermiso.listarFechaPermisoPeriodo(permisos, fechaDesde, fechaHasta);
		
		
		System.out.println(permisosPeriodo);
		
		model.addAttribute("diario", permisosDiario);
		model.addAttribute("periodo", permisosPeriodo);
		
		return ViewRouteHelper.RESULTADO_ENTRE_FECHAS;
				
	}
	
	
	
}
