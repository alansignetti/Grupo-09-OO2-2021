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

import com.unla.Grupo09OO22021ABM.entities.Usuario;
import com.unla.Grupo09OO22021ABM.helpers.ViewRouteHelper;
import com.unla.Grupo09OO22021ABM.services.IUsuarioService;

@Controller
@RequestMapping
public class UsuarioController {
	
	@Autowired
	@Qualifier("usuarioService")
	private IUsuarioService service;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Usuario> usuarios = service.listar();
		model.addAttribute("usuarios", usuarios);
		return ViewRouteHelper.INDEX;
	}
	
	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "form";
	}
	
	@PostMapping("/save")
	public String save(Model model, @Validated Usuario u) {
		service.save(u);
		return "redirect:/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(Model model, @PathVariable int id) {
		Optional<Usuario> usuario = service.listarId(id);
		model.addAttribute("usuario", usuario);
		return "form";
	}
	
	@GetMapping("/eliminar/{id}")
	public String delete(Model model, @PathVariable int id) {
		service.delete(id);
		return "redirect:/listar";
	}

}
