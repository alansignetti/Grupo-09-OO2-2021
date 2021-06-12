package com.unla.Grupo09OO22021ABM.contollers;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.zxing.WriterException;
import com.unla.Grupo09OO22021ABM.entities.Lugar;
import com.unla.Grupo09OO22021ABM.entities.Permiso;
import com.unla.Grupo09OO22021ABM.entities.PermisoDiario;
import com.unla.Grupo09OO22021ABM.entities.Persona;
import com.unla.Grupo09OO22021ABM.helpers.ViewRouteHelper;
import com.unla.Grupo09OO22021ABM.services.ILugarService;
import com.unla.Grupo09OO22021ABM.services.IPermisoDiarioService;
import com.unla.Grupo09OO22021ABM.services.IPermisoService;
import com.unla.Grupo09OO22021ABM.services.IPersonaService;
import com.unla.Grupo09OO22021ABM.services.IRodadoService;
import com.unla.Grupo09OO22021ABM.util.QRCodeGenerator;

@Controller
@RequestMapping
public class PermisoDiarioController {
	
	@Autowired
	@Qualifier("permisoDiarioService")
	private IPermisoDiarioService servicePermisoDiario;
	
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
	
	@GetMapping("/listar-permiso-diario")
	public String listar(Model model) {
		List<PermisoDiario> permisosDiarios = servicePermisoDiario.listar();
		model.addAttribute("permisosDiarios", permisosDiarios);
		return ViewRouteHelper.LISTA_PERMISO_DIARIO;
	}
	
	@GetMapping("/new-permiso-diario")
	public String agregar(Model model) throws WriterException, IOException {
		List<Persona> personas = servicePersona.listarPersonas();
		List<Lugar> lugares = serviceLugar.listarLugar();
		model.addAttribute("permisoDiario", new PermisoDiario());
		model.addAttribute("personas", personas);
		model.addAttribute("lugares", lugares);
			return ViewRouteHelper.FORM_PERMISO_DIARIO;
	}
	
	@PostMapping("/save-permiso-diario") //
	public String save(@Valid @ModelAttribute("permisoDiario") PermisoDiario pd, BindingResult bindingResult,
			Model model, RedirectAttributes attribute , @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha,@RequestParam(required = false) int desde, @RequestParam(required = false) int hasta, @RequestParam(required = false) String motivo,  @RequestParam(required = false) int personaId) throws WriterException, IOException {
		if (pd.getFecha() == null) {
			FieldError error = new FieldError("permisoDiario", "fecha", "Por favor, ingrese una fecha e Intente nuevamente");
			bindingResult.addError(error);
		}else {
			if (pd.getFecha().isBefore(LocalDate.now())) {
				FieldError error = new FieldError("permisoDiario", "fecha", "Fecha no puede ser anterior al dia de hoy. Por favor, verifique la fecha e Intente nuevamente");
				bindingResult.addError(error);
			}
		}		
		if (bindingResult.hasErrors()) {			
			List<Persona> personas = servicePersona.listarPersonas();
			List<Lugar> lugares = serviceLugar.listarLugar();
			model.addAttribute("permisoDiario", pd);
			model.addAttribute("personas", personas);
			model.addAttribute("lugares", lugares);
			return ViewRouteHelper.FORM_PERMISO_DIARIO;
		}else {
			Set<Lugar> lugares = new HashSet<>();
			lugares.add(serviceLugar.traerLugar(desde));
			lugares.add(serviceLugar.traerLugar(hasta));
			pd.setDesdeHasta(lugares);
			
			String lugarDesde = serviceLugar.traerLugar(desde).getLugar() + "("+serviceLugar.traerLugar(desde).getCodigo_postal()+")";
			String lugarHasta = serviceLugar.traerLugar(hasta).getLugar() + "("+serviceLugar.traerLugar(hasta).getCodigo_postal()+")";
			Persona persona = servicePersona.traerIdPersona(personaId);
			String nombre = persona.getNombre();
			String apellido = persona.getApellido();
			long DNI = persona.getDni();
			
			System.out.println(nombre);
			
			// para ver la imagen del qr hay que actualizar la imagen (abrirla y cerrarla en eclipse) 
			// Y despues recargar la pagina = http://localhost:8080/QR
			// hardcodeado para entender como funciona
//			String nombrePersona = persona.getNombre();
			String url = "alansignetti.github.io/Grupo-09-OO2-2021"+"?permiso=1&apellido="+apellido+"&nombre="+nombre+"&dni="+DNI+"&motivo="+motivo+"&fecha="+fecha+"&desde="+lugarDesde+"&hasta="+lugarHasta;
			
			QRCodeGenerator.generateQRCodeImage(url.replaceAll("\\s+","%20"), 200, 200, ViewRouteHelper.QR_CODE_IMAGE_PATH);
			// la idea es que cuando se guarda el permiso, se guarden esos datos en la url y se genera el qr coon esa url y despues se ve en la imagen
			//			QRCodeGenerator.generateQRCodeImage(url+"?apellido="+pd.getPedido().getApellido()+"&dni="+pd.getPedido().getDni()+"&"+pd.getPedido().getNombre(), 200, 200, ViewRouteHelper.QR_CODE_IMAGE_PATH);
			servicePermisoDiario.save(pd);
			return ViewRouteHelper.QR;
		}

	}
	
	
	@GetMapping("/listar-permisoDiario/{id}")
	public String traerDiarioPersona(@PathVariable("id") int id, Model model) {
		List<Permiso> permisos = servicePermiso.findByIdAndFetchPersonaEagerly(id);
		
		List<PermisoDiario> permisosDiario = servicePermiso.listarPermisosDiario(permisos);
		model.addAttribute("permisosDiario", permisosDiario);
		return ViewRouteHelper.LISTA_PERMISO_DIARIO;
	}

	
	

}
