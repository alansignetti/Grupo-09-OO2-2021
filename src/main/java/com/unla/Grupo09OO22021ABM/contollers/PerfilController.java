package com.unla.Grupo09OO22021ABM.contollers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.Grupo09OO22021ABM.entities.Perfil;
import com.unla.Grupo09OO22021ABM.helpers.ViewRouteHelper;
import com.unla.Grupo09OO22021ABM.services.IPerfilService;


@Controller
@RequestMapping
public class PerfilController {
	
	@Autowired
	@Qualifier("perfilService")
	private IPerfilService service;

	@PreAuthorize("hasRole('ROLE_AUDITOR') || hasRole('ROLE_ADMIN')")
	@GetMapping("/listar-perfiles")
	public String listar(Model model) {
		List<Perfil> perfiles = service.listar();
		model.addAttribute("perfiles", perfiles);
		return ViewRouteHelper.INDEX_PERFIL;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/new-perfil")
	public String agregar(Model model) {
		model.addAttribute("perfil", new Perfil());
		return ViewRouteHelper.FORM_PERFIL;
	}
	
	//, 
	@PostMapping("/save-perfil")
	public String save(@Valid @ModelAttribute("perfil") Perfil p, BindingResult bindingResult, Model model ) {
		if (service.validaTipoPerfil(p.getTipo_perfil()) == false) {
			FieldError error = new FieldError("perfil", "tipo_perfil", "El formato permitido es: ROLE_TIPOPERFIL, todo en Mayúsculas. Por favor, intente nuevamente.");
			bindingResult.addError(error);
		}
		if (bindingResult.hasErrors()) {
			model.addAttribute("perfil", p);
			return ViewRouteHelper.FORM_PERFIL;
		}else {
			service.save(p);
			return ViewRouteHelper.HOME;
		}
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/editar-perfil/{id}")
	public String editar(Model model, @PathVariable int id) {
		Optional<Perfil> perfil = service.listarId(id);
		model.addAttribute("perfil", perfil);
		return ViewRouteHelper.FORM_PERFIL;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/eliminar-perfil/{id}")
	public RedirectView delete(Model model, @PathVariable int id) {
		Perfil p = service.traerPorId(id);
		p.setEnabled(false);
		service.save(p);
		return new RedirectView(ViewRouteHelper.PERFILES);
	}

}
