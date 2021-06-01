package com.unla.Grupo09OO22021ABM.contollers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.Grupo09OO22021ABM.entities.Perfil;
import com.unla.Grupo09OO22021ABM.entities.Persona;
import com.unla.Grupo09OO22021ABM.entities.Usuario;
import com.unla.Grupo09OO22021ABM.helpers.ViewRouteHelper;
import com.unla.Grupo09OO22021ABM.models.PersonaModel;
import com.unla.Grupo09OO22021ABM.services.IPersonaService;


@Controller
public class PersonaController {
    
    @Autowired
    @Qualifier("personaService")
    private IPersonaService personaService;
    
//    @GetMapping("")
//    public ModelAndView altaPersona(){
//        ModelAndView mV = new ModelAndView(ViewRouteHelper.FORM_PERSONA);
//		mV.addObject("persona", new PersonaModel());
//		return mV;
//    }

    
	@GetMapping("/listar-personas")
	public String listar(Model model) {
		List<Persona> personas = personaService.listarPersonas();
		model.addAttribute("personas", personas);
		return ViewRouteHelper.INDEX_PERSONA;
	}
    
//	@GetMapping("/listar")
//	public String listar(Model model) {
//		List<Persona> personas = personaService.listarPersonas();
//		model.addAttribute("personas", personas);
//		return ViewRouteHelper.INDEX;
//	}
//	

    
	@GetMapping("/new-persona")
	public String agregar(Model model) {
//		List<Persona> personas = personaService.listarPersonas();		
		model.addAttribute("persona", new Persona());
//		model.addAttribute("personas", personas);
		return ViewRouteHelper.FORM_PERSONA;
	}
	
//	@PostMapping("/save-persona")
//	public RedirectView save(Model model, @Validated PersonaModel p) {
//		personaService.altaPersona(p);
//		return new RedirectView(ViewRouteHelper.PERSONAS);
//	}
	
	@PostMapping("/save-persona")
	public RedirectView save(Model model, @Validated Persona p) {
		personaService.save(p);
		return new RedirectView(ViewRouteHelper.PERSONAS);
	}
	
	@GetMapping("/editar-persona/{id}")
	public String editar(Model model, @PathVariable int id) {
		Optional<Persona>	persona = personaService.listarId(id);
		model.addAttribute("persona", persona);
		return ViewRouteHelper.FORM_USUARIO;
	}
	
	@GetMapping("/eliminar-persona/{id}")
	public RedirectView delete(Model model, @PathVariable int id) {
		personaService.delete(id);
		return new RedirectView(ViewRouteHelper.PERSONAS);
	}
	
}