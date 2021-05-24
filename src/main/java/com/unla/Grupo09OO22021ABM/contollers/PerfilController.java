package com.unla.Grupo09OO22021ABM.contollers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unla.Grupo09OO22021ABM.entities.Perfil;
import com.unla.Grupo09OO22021ABM.services.IPerfilService;


@Controller
@RequestMapping
public class PerfilController {
	
	@Autowired
	@Qualifier("perfilService")
	private IPerfilService service;
	
	@GetMapping("/listar-perfiles")
	public String listar(Model model) {
		List<Perfil> perfiles = service.listar();
		model.addAttribute("perfiles", perfiles);
		return "index-perfil";
	}
	
	@GetMapping("/new-perfil")
	public String agregar(Model model) {
		model.addAttribute("perfil", new Perfil());
		return "form-perfil";
	}
	
	@PostMapping("/save-perfil")
	public String save(Model model, @Validated Perfil p) {
		service.save(p);
		return "redirect:/listar-perfiles";
	}
	
	@GetMapping("/editar-perfil/{id}")
	public String editar(Model model, @PathVariable int id) {
		Optional<Perfil> perfil = service.listarId(id);
		model.addAttribute("perfil", perfil);
		return "form-perfil";
	}
	
	@GetMapping("/eliminar-perfil/{id}")
	public String delete(Model model, @PathVariable int id) {
		service.delete(id);
		return "redirect:/listar-perfiles";
	}

}
