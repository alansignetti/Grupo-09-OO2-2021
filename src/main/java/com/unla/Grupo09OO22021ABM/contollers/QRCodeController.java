package com.unla.Grupo09OO22021ABM.contollers;

<<<<<<< HEAD
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
=======

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
>>>>>>> main
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
import com.unla.Grupo09OO22021ABM.util.QRCodeGenerator;

@RestController
public class QRCodeController {
	
	//Lugar donde se va a almacenar la imagen del codigo QR.
	private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/QRCode.png";

	
    @GetMapping(value = "/genrateAndDownloadQRCode/{codeText}/{width}/{height}")
		public void download(
				@PathVariable("codeText") String codeText,
				@PathVariable("width") Integer width,
				@PathVariable("height") Integer height)
			    throws Exception {
			        QRCodeGenerator.generateQRCodeImage(codeText, width, height, QR_CODE_IMAGE_PATH);
			    }

    @GetMapping(value = "/genrateQRCode/{codeText}/{width}/{height}")
=======
import com.unla.Grupo09OO22021ABM.helpers.ViewRouteHelper;
import com.unla.Grupo09OO22021ABM.util.QRCodeGenerator;

@RestController //Rest
public class QRCodeController {
	// lo dejo acá asi lo encontramos facil
	
	private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/static/QRCode.png";


    @GetMapping(value = "/generarQR/{url}/{grupo}") // alansignetti.github.io/Grupo-09-OO2-2021/?
		public void download(
				@PathVariable("url") String url
				,@PathVariable("grupo") String grupo)
			    throws Exception {
			        QRCodeGenerator.generateQRCodeImage(url+"/"+grupo+"?apellido=signetti&dni=32&nombre=alan", 200, 200, QR_CODE_IMAGE_PATH);
			    }

    @GetMapping(value = "/generateQRCode/{codeText}/{width}/{height}")
>>>>>>> main
   	public ResponseEntity<byte[]> generateQRCode(
   			@PathVariable("codeText") String codeText,
   			@PathVariable("width") Integer width,
   			@PathVariable("height") Integer height)
   		    throws Exception {
   		        return ResponseEntity.status(HttpStatus.OK).body(QRCodeGenerator.getQRCodeImage(codeText, width, height));
   		    }
}