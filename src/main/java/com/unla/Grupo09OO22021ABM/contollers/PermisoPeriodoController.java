package com.unla.Grupo09OO22021ABM.contollers;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.unla.Grupo09OO22021ABM.entities.Lugar;
import com.unla.Grupo09OO22021ABM.entities.Permiso;
import com.unla.Grupo09OO22021ABM.entities.PermisoPeriodo;
import com.unla.Grupo09OO22021ABM.entities.Persona;
import com.unla.Grupo09OO22021ABM.entities.Rodado;
import com.unla.Grupo09OO22021ABM.helpers.ViewRouteHelper;
import com.unla.Grupo09OO22021ABM.services.ILugarService;
import com.unla.Grupo09OO22021ABM.services.IPermisoPeriodoService;
import com.unla.Grupo09OO22021ABM.services.IPermisoService;
import com.unla.Grupo09OO22021ABM.services.IPersonaService;
import com.unla.Grupo09OO22021ABM.services.IRodadoService;



@Controller
@RequestMapping
public class PermisoPeriodoController {
	
	
	@Autowired
	@Qualifier("permisoPeriodoService")
	private IPermisoPeriodoService servicePermisoPeriodo;
	
	@Autowired
	@Qualifier("permisoService")
	private IPermisoService servicePermiso;
	
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
		return ViewRouteHelper.LISTA_PERMISO_PERIODO;
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
	
	@PostMapping("/save-permiso-periodo") //,
    public String save(@Valid @ModelAttribute("permisoPeriodo") PermisoPeriodo pp, BindingResult bindingResult, 
    		Model model, @RequestParam(required=false) int desde, @RequestParam(required=false) int hasta) {
		if (pp.getFecha() == null) {
			FieldError error = new FieldError("permisoDiario", "fecha", "Por favor, ingrese una fecha e Intente nuevamente");
			bindingResult.addError(error);
		}else {
			if (pp.getFecha().isBefore(LocalDate.now())) {
				FieldError error = new FieldError("permisoDiario", "fecha", "Fecha no puede ser anterior al dia de hoy. Por favor, verifique la fecha e Intente nuevamente");
				bindingResult.addError(error);
			}
		}
		if (pp.getCantDias() ==0) {
			FieldError error = new FieldError("permisoDiario", "cantDias", "Por favor, ingrese la Cantidad de Dias deseados e Intente nuevamente");
			bindingResult.addError(error);
		}
		if (bindingResult.hasErrors()) {
			List<Persona> personas = servicePersona.listarPersonas();
			List<Lugar> lugares = serviceLugar.listarLugar();
			List<Rodado> rodados = serviceRodado.listar();
			model.addAttribute("permisoPeriodo", pp);
			model.addAttribute("personas", personas);
			model.addAttribute("lugares", lugares);
			model.addAttribute("rodados", rodados);
			return ViewRouteHelper.FORM_PERMISO_PERIODO;
			
		}else {
			 Set<Lugar> lugares = new HashSet<>();
		        lugares.add(serviceLugar.traerLugar(desde));
		        lugares.add(serviceLugar.traerLugar(hasta));
		        pp.setDesdeHasta(lugares);
		        servicePermisoPeriodo.save(pp);
		        return ViewRouteHelper.HOME;
		}       
    }
	
	
	@GetMapping("/listar-permisoPeriodo/{id}")
	public String traerPeriodoPersona(@PathVariable("id") int id, Model model) {
		List<Permiso> permisos = servicePermiso.findByIdAndFetchPersonaEagerly(id); // traigo la lista de permisos para despues obtener los permisos periodo
		List<PermisoPeriodo> permisosPeriodo = servicePermiso.listarPermisosPeriodo(permisos);
		model.addAttribute("permisosPeriodo",permisosPeriodo);
		return ViewRouteHelper.LISTA_PERMISO_PERIODO;
	}
	

}
