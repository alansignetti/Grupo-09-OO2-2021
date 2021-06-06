package com.unla.Grupo09OO22021ABM.contollers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.Grupo09OO22021ABM.entities.Lugar;
import com.unla.Grupo09OO22021ABM.entities.Permiso;
import com.unla.Grupo09OO22021ABM.entities.PermisoDiario;
import com.unla.Grupo09OO22021ABM.entities.Persona;
import com.unla.Grupo09OO22021ABM.helpers.ViewRouteHelper;
import com.unla.Grupo09OO22021ABM.services.ILugarService;
import com.unla.Grupo09OO22021ABM.services.IPermisoDiarioService;
import com.unla.Grupo09OO22021ABM.services.IPermisoPeriodoService;
import com.unla.Grupo09OO22021ABM.services.IPermisoService;
import com.unla.Grupo09OO22021ABM.services.IPersonaService;
import com.unla.Grupo09OO22021ABM.services.IRodadoService;

@Controller
@RequestMapping
public class PermisoDiarioController {
	
	@Autowired
	@Qualifier("permisoDiarioService")
	private IPermisoDiarioService servicePermisoDiario;
	
	@Autowired
	@Qualifier("permisoService")
	private IPermisoService servicePermiso;
	
	@Autowired
	@Qualifier("personaService")
	private IPersonaService servicePersona;
	
	@Autowired
	@Qualifier("lugarService")
	private ILugarService serviceLugar;
	
	@Autowired
	@Qualifier("rodadoService")
	private IRodadoService serviceRodado;
	
	@GetMapping("/listar-permiso-diario")
	public String listar(Model model) {
		List<PermisoDiario> permisosDiarios = servicePermisoDiario.listar();
		model.addAttribute("permisosDiarios", permisosDiarios);
		return ViewRouteHelper.LISTA_PERMISO_DIARIO;
	}
	
	@GetMapping("/new-permiso-diario")
	public String agregar(Model model) {
		List<Persona> personas = servicePersona.listarPersonas();
		List<Lugar> lugares = serviceLugar.listarLugar();
		model.addAttribute("permisoDiario", new PermisoDiario());
		model.addAttribute("personas", personas);
		model.addAttribute("lugares", lugares);
		return ViewRouteHelper.FORM_PERMISO_DIARIO;
	}
	
	@PostMapping("/save-permiso-diario")
	public RedirectView save(Model model, @Validated PermisoDiario pd, RedirectAttributes attribute 
			,@RequestParam(required = false) int desde,
			   @RequestParam(required = false) int hasta
			) 	{
		
		
		Set<Lugar> lugares = new HashSet<>();
		lugares.add(serviceLugar.traerLugar(desde));
		lugares.add(serviceLugar.traerLugar(hasta));
		pd.setDesdeHasta(lugares);
		servicePermisoDiario.save(pd);
		attribute.addFlashAttribute("success","El Permiso se agrego con Exito");
		return new RedirectView(ViewRouteHelper.HOME);
	}
	
	
	@GetMapping("/listar-permisoDiario/{id}")
	public String traerDiarioPersona(@PathVariable("id") int id, Model model) {
		List<Permiso> permisos = servicePermiso.findByIdAndFetchPersonaEagerly(id);
		List<PermisoDiario> permisosDiario = servicePermiso.listarPermisosDiario(permisos);
		model.addAttribute("permisosDiario", permisosDiario);
		return ViewRouteHelper.LISTA_PERMISO_DIARIO;
	}

	
	

}
