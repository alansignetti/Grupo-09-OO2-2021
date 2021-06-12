package com.unla.Grupo09OO22021ABM.util;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.unla.Grupo09OO22021ABM.entities.Usuario;
import com.unla.Grupo09OO22021ABM.helpers.ViewRouteHelper;
import com.unla.Grupo09OO22021ABM.services.IPerfilService;
import com.unla.Grupo09OO22021ABM.services.IUsuarioService;


@Component(ViewRouteHelper.INDEX)
public class ExportPDF extends AbstractPdfView{
	
	@Autowired
	@Qualifier("usuarioService")
	private IUsuarioService service;

	@Autowired
	@Qualifier("perfilService")
	private IPerfilService service2;

	
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Usuario> usuarios = service.listar();
		PdfPTable tablaUsuarios = new PdfPTable(5);
		
		usuarios.forEach(usuario ->{
			tablaUsuarios.addCell(usuario.getNombre());
			tablaUsuarios.addCell(usuario.getApellido());
			tablaUsuarios.addCell(usuario.getTipo_dni());
			tablaUsuarios.addCell(usuario.getEmail());
			tablaUsuarios.addCell(usuario.getUsername());
			tablaUsuarios.addCell(usuario.getPerfil().getTipo_perfil());		
			});
		document.add(tablaUsuarios);
	}

}
