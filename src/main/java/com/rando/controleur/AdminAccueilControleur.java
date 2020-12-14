package com.rando.controleur;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rando.modele.User;
import com.rando.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminAccueilControleur {
	
	@Autowired
	UserService userService;

	@GetMapping({"/", "/accueil"})
	public String accueillir(HttpServletRequest request, Model model) { 
		if(request.getSession(false) == null) {
			System.out.println("y a rien");
		}else {
			System.out.println(request.getSession().getAttribute("userok"));
		}
		model.addAttribute("nomPage", "Accueil");
		return "accueil";
	}
	
	@GetMapping({"/login"})
	public String connexion(HttpServletRequest request) {
		return "login";
	}
	
	@GetMapping({"/logout"})
	public String deconnexion(HttpServletRequest request) {
		request.getSession().setAttribute("userok", null);
		if(request.getSession(false) == null) {
			System.out.println("y a rien");
		}else {
			System.out.println(request.getSession().getAttribute("userok"));
		}
		return "redirect:/";
	}
	
	@PostMapping({"/login"})
	public String postLogin(Model model, HttpServletRequest request, RedirectAttributes redirectAttributes, @RequestParam("username") String username, @RequestParam("password") String password) {
		User userToCheck = new User(username, password, null);
		if(userService.checkUser(userToCheck)) {
			request.getSession().setAttribute("userok", userToCheck);
			
			return "redirect:/admin/";
		}else{
			model.addAttribute("message", "nom d'utilisateur ou mot de passe non valide");
			model.addAttribute("error", "Erreur");
			
			return "login";
		}
	}
}
