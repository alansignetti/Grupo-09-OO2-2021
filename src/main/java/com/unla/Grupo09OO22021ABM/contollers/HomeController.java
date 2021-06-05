package com.unla.Grupo09OO22021ABM.contollers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
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
	
}
