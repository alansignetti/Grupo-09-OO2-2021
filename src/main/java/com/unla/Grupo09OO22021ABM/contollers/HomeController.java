package com.unla.Grupo09OO22021ABM.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.Grupo09OO22021ABM.helpers.ViewRouteHelper;


@Controller
public class HomeController {
	
	
	@GetMapping("/")
	public RedirectView redirectToHome() {
		return new RedirectView(ViewRouteHelper.HOME);
	}
	

	
	@RequestMapping({"/","/home"})
    public String home() {
      return ViewRouteHelper.HOME;
    }


	
	@GetMapping("/index")
	public String index() {
		return ViewRouteHelper.HOME;
	}
	
	@GetMapping("/QR")
	public String QrCode(){
		return ViewRouteHelper.QR;
	}
	
}
