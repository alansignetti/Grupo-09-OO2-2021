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


import com.unla.Grupo09OO22021ABM.entities.Rodado;

import com.unla.Grupo09OO22021ABM.helpers.ViewRouteHelper;
import com.unla.Grupo09OO22021ABM.services.IRodadoService;

@Controller
@RequestMapping
public class RodadoController {
	
	@Autowired
	@Qualifier("rodadoService")
	private IRodadoService serviceRodado;
	
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
	
	@PostMapping("/save-rodado")
	public RedirectView save(Model model, @Validated Rodado r, RedirectAttributes attribute ) {
		serviceRodado.save(r);
		attribute.addFlashAttribute("success","El Rodado se agrego con Exito");
		return new RedirectView(ViewRouteHelper.RODADOS);
	}

}
