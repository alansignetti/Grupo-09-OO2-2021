package com.unla.Grupo09OO22021ABM.contollers;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import com.unla.Grupo09OO22021ABM.entities.Persona;
import com.unla.Grupo09OO22021ABM.helpers.ViewRouteHelper;
import com.unla.Grupo09OO22021ABM.services.IPersonaService;


@Controller
public class PersonaController {
    
    @Autowired
    @Qualifier("personaService")
    private IPersonaService personaService;
    

	@GetMapping("/listar-personas")
	public String listarPersonas(Model model) {
		List<Persona> personas = personaService.listarPersonas();
		model.addAttribute("personas", personas);
		return ViewRouteHelper.INDEX_PERSONA;
	}

	@GetMapping("/new-persona")
	public String agregar(Model model) {	
		model.addAttribute("persona", new Persona());
		return ViewRouteHelper.FORM_PERSONA;
	}
	
	@PostMapping("/save-persona")
	public String save(@Valid @ModelAttribute("persona") Persona p, BindingResult bindingResult) { 		
		if (personaService.findByDni(p.getDni())!=null && personaService.findByDni(p.getDni()).getId_persona() != p.getId_persona()) {
			FieldError error = new FieldError("persona", "dni", "Ya existe una Persona registrada con DNI: "+ p.getDni() + ". Intente nuevamente");
			bindingResult.addError(error);
		}
		if(bindingResult.hasErrors()) {
			return ViewRouteHelper.FORM_PERSONA;
		}else {
			personaService.save(p);
			return ViewRouteHelper.HOME;
		}		
	}
	
	@GetMapping("/editar-persona/{id}")
	public String editar(Model model, @PathVariable int id) {
		Optional<Persona>	persona = personaService.listarIdPersona(id);
		model.addAttribute("persona", persona);
		return ViewRouteHelper.FORM_PERSONA;
	}
	
	@GetMapping("/eliminar-persona/{id}")
	public RedirectView delete(Model model, @PathVariable int id) {
		personaService.delete(id);
		return new RedirectView(ViewRouteHelper.PERSONAS);
	}
	
	@GetMapping("/traerPersonaDNI")
	public String traerPersonaDNI(Model model) {
		return ViewRouteHelper.PERSONA_DNI;
	}
	
	@GetMapping("/traerPermisoPorPersona")
	public String traerPermisoPorPersona(@RequestParam long dni, Model model,RedirectAttributes attribute) {
		List<Persona> personas = new ArrayList<Persona>();
		Persona persona = personaService.traerPorDni(dni);
		if(persona==null) {
			model.addAttribute("mensaje","El dni ingresado no se encuentra en la base de datos");
			return ViewRouteHelper.PERSONA_DNI;
		}		
		personas.add(persona);
		model.addAttribute("personas", personas);
		return ViewRouteHelper.PERMISO_PERSONA;
	}

}