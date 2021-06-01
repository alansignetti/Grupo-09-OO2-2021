package com.unla.Grupo09OO22021ABM.contollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.Grupo09OO22021ABM.entities.Lugar;

import com.unla.Grupo09OO22021ABM.entities.PermisoPeriodo;
import com.unla.Grupo09OO22021ABM.entities.Persona;
import com.unla.Grupo09OO22021ABM.entities.Rodado;
import com.unla.Grupo09OO22021ABM.helpers.ViewRouteHelper;
import com.unla.Grupo09OO22021ABM.services.ILugarService;
import com.unla.Grupo09OO22021ABM.services.IPermisoPeriodoService;
import com.unla.Grupo09OO22021ABM.services.IPersonaService;
import com.unla.Grupo09OO22021ABM.services.IRodadoService;



@Controller
@RequestMapping
public class PermisoPeriodoController {
	
	@Autowired
	@Qualifier("permisoPeriodoService")
	private IPermisoPeriodoService servicePermisoPeriodo;
	
	@Autowired
	@Qualifier("personaService")
	private IPersonaService servicePersona;
	
	@Autowired
	@Qualifier("lugarService")
	private ILugarService serviceLugar;
	
	@Autowired
	@Qualifier("rodadoService")
	private IRodadoService serviceRodado;
	
	@GetMapping("/listar-permiso-periodo")
	public String listar(Model model) {
		List<PermisoPeriodo> permisosPeriodo = servicePermisoPeriodo.listar();
		model.addAttribute("permisosPeriodo", permisosPeriodo);
		return ViewRouteHelper.INDEX_PERMISO_PERIODO;
	}
	
	@GetMapping("/new-permiso-periodo")
	public String agregar(Model model) {
		List<Persona> personas = servicePersona.listarPersonas();
		List<Lugar> lugares = serviceLugar.listarLugar();
		List<Rodado> rodados = serviceRodado.listar();
		model.addAttribute("permisoPeriodo", new PermisoPeriodo());
		model.addAttribute("personas", personas);
		model.addAttribute("lugares", lugares);
		model.addAttribute("rodados", rodados);
		return ViewRouteHelper.FORM_PERMISO_PERIODO;
	}
	
	@PostMapping("/save-permiso-periodo")
	public RedirectView save(Model model, @Validated PermisoPeriodo pp, RedirectAttributes attribute ) {
		servicePermisoPeriodo.save(pp);
		attribute.addFlashAttribute("success","El Permiso se agrego con Exito");
		return new RedirectView(ViewRouteHelper.PERMISO_PERIODO);
	}

}
