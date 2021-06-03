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

import com.unla.Grupo09OO22021ABM.entities.PermisoDiario;
import com.unla.Grupo09OO22021ABM.entities.Persona;

import com.unla.Grupo09OO22021ABM.helpers.ViewRouteHelper;
import com.unla.Grupo09OO22021ABM.services.ILugarService;
import com.unla.Grupo09OO22021ABM.services.IPermisoDiarioService;
import com.unla.Grupo09OO22021ABM.services.IPersonaService;

@Controller
@RequestMapping
public class PermisoDiarioController {
	
	@Autowired
	@Qualifier("permisoDiarioService")
	private IPermisoDiarioService servicePermisoDiario;
	
	@Autowired
	@Qualifier("personaService")
	private IPersonaService servicePersona;
	
	@Autowired
	@Qualifier("lugarService")
	private ILugarService serviceLugar;
	
	@GetMapping("/listar-permiso-diario")
	public String listar(Model model) {
		List<PermisoDiario> permisosDiarios = servicePermisoDiario.listar();
		model.addAttribute("permisosDiarios", permisosDiarios);
		return ViewRouteHelper.INDEX_PERMISO_DIARIO;
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
	public RedirectView save(Model model, @Validated PermisoDiario pd, RedirectAttributes attribute ) {
		servicePermisoDiario.save(pd);
		attribute.addFlashAttribute("success","El Permiso se agrego con Exito");
		return new RedirectView(ViewRouteHelper.HOME);
	}
	
	

}
