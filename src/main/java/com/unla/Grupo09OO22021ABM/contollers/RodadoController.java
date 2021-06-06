package com.unla.Grupo09OO22021ABM.contollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

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
	
	@PostMapping("/save-rodado")
	public RedirectView save(Model model, @Validated Rodado r, RedirectAttributes attribute ) {
		serviceRodado.save(r);
		attribute.addFlashAttribute("success","El Rodado se agrego con Exito");
		return new RedirectView(ViewRouteHelper.HOME);
	}
	
	//@PreAuthorize("hasRole('ROLE_AUDITOR')")
	@GetMapping("/rodado/permisos")
	public String listarRodado(@RequestParam String dominio, Model model,RedirectAttributes attribute) {
		// List<Rodado> rodados = new ArrayList<Rodado>();
		//model.addAttribute("titulo", "Rodado");
		Rodado rodado = serviceRodado.findByDominio(dominio);
		
		System.out.println(rodado);
		
		List<PermisoPeriodo> listadoDePermisos = servicePermisoPeriodo.findByIdAndFetchRodadoEagerly(rodado.getId_rodado());
		
		for (PermisoPeriodo permiso : listadoDePermisos) {
			 System.out.println(permiso.getPedido().getNombre());
			 System.out.println(permiso.getPedido().getApellido());
		}
		
		model.addAttribute("titulo", "Permisos por periodo que solicito el dominio " + rodado.getDominio());
		model.addAttribute("lista", listadoDePermisos);
		return ViewRouteHelper.LISTADO_PERMISO_RODADO;
		/*if(rodado1==null) {
			attribute.addFlashAttribute("success","Este dominio no se encuentra en la base de datos");
			return ViewRouteHelper.RODADO_SELECCIONAR_DOMINIO_REDIRECT;
		}*/
	
	}

}
