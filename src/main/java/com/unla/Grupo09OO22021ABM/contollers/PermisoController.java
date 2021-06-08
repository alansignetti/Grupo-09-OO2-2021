package com.unla.Grupo09OO22021ABM.contollers;

import java.time.LocalDate;
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

import com.unla.Grupo09OO22021ABM.entities.Lugar;
import com.unla.Grupo09OO22021ABM.entities.Permiso;
import com.unla.Grupo09OO22021ABM.entities.PermisoDiario;
import com.unla.Grupo09OO22021ABM.entities.PermisoPeriodo;
import com.unla.Grupo09OO22021ABM.helpers.ViewRouteHelper;
import com.unla.Grupo09OO22021ABM.services.ILugarService;
import com.unla.Grupo09OO22021ABM.services.IPermisoService;

@Controller
@RequestMapping
public class PermisoController {
 
	@Autowired
	@Qualifier("permisoService")
	private IPermisoService servicePermiso;
	
	@Autowired
	@Qualifier("lugarService")
	private ILugarService serviceLugar;
	
	
	@GetMapping("/permiso-entre-fechas")
	public String buscarPorFecha (Model model) {	
		return ViewRouteHelper.PERMISO_ENTRE_FECHAS;
	}
	
	
	@GetMapping("/permisos-fecha")
	public String traerPermisosPorFecha(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaDesde,  @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaHasta, Model model,RedirectAttributes attribute) {
		List<Permiso> permisos = servicePermiso.listar();
		List<PermisoDiario> permisosDiario = servicePermiso.listarPermisosDiario(permisos);
		List<PermisoPeriodo> permisosPeriodo = servicePermiso.listarPermisosPeriodo(permisos);

		List<PermisoPeriodo> permisosPeriodoPorFecha = servicePermiso.listarFechaPermisoPeriodo(permisosPeriodo, fechaDesde, fechaHasta);
		List<PermisoDiario> permisosDiarioPorFecha = servicePermiso.listarFechaPermisoDiario(permisosDiario, fechaHasta);
		
		model.addAttribute("diario", permisosDiarioPorFecha);
		model.addAttribute("periodo", permisosPeriodoPorFecha);
		
		return ViewRouteHelper.RESULTADO_ENTRE_FECHAS;
				
	}
	
	@GetMapping("/permiso-entre-fechas-origen")
	public String buscarPorFechaYOrigen (Model model) {	
		List<Lugar> lugares = serviceLugar.listarLugar();
		model.addAttribute("lugares", lugares);
		return ViewRouteHelper.PERMISO_ENTRE_FECHAS_ORIGEN;
	}
	
	@GetMapping("/permisos-fecha-origen")
	public String traerPermisosPorFechaYOrigen(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaDesde,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaHasta,@RequestParam(required=false) int desde,
			Model model,RedirectAttributes attribute) {
		Lugar lugar = serviceLugar.traerLugar(desde);
		List<Permiso> permisosPorLugar = servicePermiso.findByIdAndFetchLugarEagerly(lugar.getIdLugar());
		List<PermisoDiario> permisosDiario = servicePermiso.listarPermisosDiario(permisosPorLugar);
		List<PermisoPeriodo> permisosPeriodo = servicePermiso.listarPermisosPeriodo(permisosPorLugar);
		
		List<PermisoPeriodo> permisosPeriodoPorFecha = servicePermiso.listarFechaPermisoPeriodo(permisosPeriodo, fechaDesde, fechaHasta);
		List<PermisoDiario> permisosDiarioPorFecha = servicePermiso.listarFechaPermisoDiario(permisosDiario, fechaHasta);
		
		model.addAttribute("diario", permisosDiarioPorFecha);
		model.addAttribute("periodo", permisosPeriodoPorFecha);
		
		return ViewRouteHelper.RESULTADO_ENTRE_FECHAS_ORIGEN;
	}
	
	@GetMapping("/permiso-entre-fechas-destino")
	public String buscarPorFechaYDestino (Model model) {	
		List<Lugar> lugares = serviceLugar.listarLugar();
		model.addAttribute("lugares", lugares);
		return ViewRouteHelper.PERMISO_ENTRE_FECHAS_DESTINO;
	}
	
	@GetMapping("/permisos-fecha-destino")
	public String traerPermisosPorFechaYDestino(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaDesde,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaHasta,@RequestParam(required=false) int hasta,
			Model model,RedirectAttributes attribute) {
		Lugar lugar = serviceLugar.traerLugar(hasta);
		List<Permiso> permisosPorLugar = servicePermiso.findByIdAndFetchLugarEagerly(lugar.getIdLugar());
		List<PermisoDiario> permisosDiario = servicePermiso.listarPermisosDiario(permisosPorLugar);
		List<PermisoPeriodo> permisosPeriodo = servicePermiso.listarPermisosPeriodo(permisosPorLugar);
		
		List<PermisoPeriodo> permisosPeriodoPorFecha = servicePermiso.listarFechaPermisoPeriodo(permisosPeriodo, fechaDesde, fechaHasta);
		List<PermisoDiario> permisosDiarioPorFecha = servicePermiso.listarFechaPermisoDiario(permisosDiario, fechaHasta);
		
		model.addAttribute("diario", permisosDiarioPorFecha);
		model.addAttribute("periodo", permisosPeriodoPorFecha);
		
		return ViewRouteHelper.RESULTADO_ENTRE_FECHAS_DESTINO;
	}
	
	
	
}
