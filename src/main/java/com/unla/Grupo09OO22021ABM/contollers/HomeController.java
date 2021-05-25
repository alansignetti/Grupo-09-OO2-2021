package com.unla.Grupo09OO22021ABM.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.Grupo09OO22021ABM.helpers.ViewRouteHelper;


@Controller
public class HomeController {
	
	
	@GetMapping("/")
	public RedirectView redirectToHome() {
		return new RedirectView(ViewRouteHelper.HOME);
	}
	
	@GetMapping("/home")
	public String home() {
		return ViewRouteHelper.HOME;
	}
	
	
}
