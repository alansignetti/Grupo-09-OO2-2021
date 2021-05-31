package com.unla.Grupo09OO22021ABM.contollers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.Grupo09OO22021ABM.entities.Perfil;
import com.unla.Grupo09OO22021ABM.entities.Usuario;
import com.unla.Grupo09OO22021ABM.helpers.ViewRouteHelper;
import com.unla.Grupo09OO22021ABM.services.IPerfilService;
import com.unla.Grupo09OO22021ABM.services.IUsuarioService;

@Controller
@RequestMapping
public class UsuarioController {
	
	@Autowired
	@Qualifier("usuarioService")
	private IUsuarioService service;
	
	@Autowired
	@Qualifier("perfilService")
	private IPerfilService service2;
	
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Usuario> usuarios = service.listar();
		model.addAttribute("usuarios", usuarios);
		return ViewRouteHelper.INDEX;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/new")
	public String agregar(Model model) {
		List<Perfil> perfiles = service2.listar();		
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("perfiles", perfiles);
		return ViewRouteHelper.FORM_USUARIO;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/save")
	public RedirectView save(Model model, @Validated Usuario u) {
		service.save(u);
		return new RedirectView(ViewRouteHelper.USUARIOS);
	}
	
	@GetMapping("/editar/{id}")
	public String editar(Model model, @PathVariable int id) {
		Optional<Usuario> usuario = service.listarId(id);
		model.addAttribute("usuario", usuario);
		return ViewRouteHelper.FORM_USUARIO;
	}
	
	@GetMapping("/eliminar/{id}")
	public RedirectView delete(Model model, @PathVariable int id) {
		service.delete(id);
		return new RedirectView(ViewRouteHelper.USUARIOS);
	}
	
	@GetMapping("/login")
	public String login(Model model,
						@RequestParam(name="error",required=false) String error,
						@RequestParam(name="logout", required=false) String logout) {
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		return ViewRouteHelper.USER_LOGIN;
	}
	
	@GetMapping("/logout")
	public String logout(Model model) {
		return ViewRouteHelper.USER_LOGOUT;
	}
	
	@GetMapping("/loginsuccess")
	public RedirectView loginCheck() {
		return new RedirectView(ViewRouteHelper.HOME);
	}

}
