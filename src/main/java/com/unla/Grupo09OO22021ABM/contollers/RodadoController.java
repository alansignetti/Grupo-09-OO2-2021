package com.unla.Grupo09OO22021ABM.contollers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.unla.Grupo09OO22021ABM.entities.PermisoPeriodo;
import com.unla.Grupo09OO22021ABM.entities.Rodado;

import com.unla.Grupo09OO22021ABM.helpers.ViewRouteHelper;
import com.unla.Grupo09OO22021ABM.services.IPermisoPeriodoService;
import com.unla.Grupo09OO22021ABM.services.IRodadoService;

@Controller
@RequestMapping
public class RodadoController {
	
	@Autowired
	@Qualifier("rodadoService")
	private IRodadoService serviceRodado;
	

	@Autowired
	@Qualifier("permisoPeriodoService")
	private IPermisoPeriodoService servicePermisoPeriodo;
	
	@GetMapping("/listar-rodados")
	public String listar(Model model) {
		List<Rodado> rodados = serviceRodado.listar();
		model.addAttribute("rodados", rodados);
		return ViewRouteHelper.INDEX_RODADO;
	}
	
	@GetMapping("/new-rodado")
	public String agregar(Model model) {	
		model.addAttribute("rodado", new Rodado());
		return ViewRouteHelper.FORM_RODADO;
	}
	
	@GetMapping("/buscar_por_dominio")
	public String buscarPorDominio (Model model) {	
		return ViewRouteHelper.PERMISO_PERIODO_POR_RODADO;
	}
	
	@PostMapping("/save-rodado") //
	public String save(@Valid @ModelAttribute("rodado") Rodado r, BindingResult bindingResult, Model model, RedirectAttributes attribute ) {
		if ( serviceRodado.validarRodado(r.getDominio()) == false ) {
			FieldError error = new FieldError("rodado", "dominio", "Formatos válidos: LLL-NNN o LL-NNN-LL. Por favor, ingrese un Dominio Válido e Intente nuevamente");
			bindingResult.addError(error);
		}
		if (bindingResult.hasErrors()) {
			model.addAttribute("rodado", r);
			return ViewRouteHelper.FORM_RODADO;
		}else {
			serviceRodado.save(r);
			return ViewRouteHelper.HOME;
		}
	}
	
	@GetMapping("/rodado/permisos")
	public String listarRodado(@RequestParam String dominio, Model model,RedirectAttributes attribute) {
		Rodado rodado = serviceRodado.findByDominio(dominio);		
		List<PermisoPeriodo> listadoDePermisos = servicePermisoPeriodo.findByIdAndFetchRodadoEagerly(rodado.getId_rodado());
		model.addAttribute("lista", listadoDePermisos);
		return ViewRouteHelper.LISTADO_PERMISO_RODADO;
	
	}

}
