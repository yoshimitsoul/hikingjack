package com.rando.controleur;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JspContactControleur {

	@GetMapping("/contact")
	public String contacter() {
		return "contact";
		
	}
}
