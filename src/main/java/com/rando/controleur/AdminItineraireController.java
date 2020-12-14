package com.rando.controleur;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.rando.dao.EtapeRepository;
import com.rando.dao.ItineraireRepository;
import com.rando.dao.NiveauRepository;
import com.rando.modele.Itineraire;
import com.rando.modele.Niveau;
import com.rando.service.ItineraireService;
import com.rando.validator.ItineraireValidator;

@ComponentScan("com.rando.validator")
@Controller
@RequestMapping("/admin")
public class AdminItineraireController {
	
	@Autowired
	ItineraireRepository itineraireRepository;
	
	@Autowired
	EtapeRepository etapeRepository;
	
	@Autowired
	ItineraireService itineraireService;
	
	@Autowired
	ItineraireValidator itineraireValidator;
	
	@Autowired
	NiveauRepository niveauRepository;
	
	//affiche la page des listes d'itinéraires
	@GetMapping({"/listeItineraires"})
	public String getItineraires(Model model) {
		
		List<Itineraire> listeItineraires = itineraireService.getItineraireAvecEtapes();
		
		model.addAttribute("listeItineraires", listeItineraires);
		return "listeItineraires";
	}
	
	//affiche détail itinéraire
	@GetMapping({"/itineraire/{idItineraire}"})
	public String getItineraire(Model model, @PathVariable("idItineraire") String idItineraire) {
		
		Itineraire itineraire = itineraireService.getItineraire(Integer.parseInt(idItineraire));
		
		model.addAttribute("itineraire", itineraire);
		
		return "detailItineraire";
	}
	
	//affichage de la page du formulaire de création d'un itinéraire.
	@GetMapping({"/creerItineraire"})
	public String getAjoutItineraire(Model model, @ModelAttribute("ajoutItineraire") Itineraire itineraireAAjouter, BindingResult result) {
		if(itineraireAAjouter.getIdItineraire() > 0) {
			model.addAttribute("itineraireAAjouter", itineraireAAjouter);
		}else {
			model.addAttribute("itineraireAAjouter", new Itineraire());
		}
		
		List<Niveau> listeNiveau = getNiveauForm();
		model.addAttribute("listeNiveaux", listeNiveau);
		
		return "creerItineraire";
	}
	
	//validation du formulaire d'ajout d'un itineraire
	@PostMapping({"/itineraire-ajout"})
	public String postAjoutItineraire(Model model, @ModelAttribute("itineraireAAjouter") @Valid Itineraire itineraireAAjouter, BindingResult result, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		RedirectView redirect = new RedirectView(request.getContextPath() + "/creerItineraire");
		redirect.setExposeModelAttributes(false);
		
		//vérification du niveau de l'itinéraire à part (pour éviter un dto)
		if(!(itineraireAAjouter.getNiveauItineraire().getIdNiveau() > 0)) {
			result.addError(new ObjectError("niveauItineraire", "Le niveau est obligatoire"));
		}
		
		//si erreur, retour au formulaire avec les erreurs
		if(result.hasErrors()) {
			model.addAttribute("messageErreurFormulaire", "Merci de vérifier le formulaire, une erreur s'est produite ! Itinéraire non ajouté");
			
			List<Niveau> listeNiveau = getNiveauForm();
			model.addAttribute("listeNiveaux", listeNiveau);
			
			
	    	return "creerItineraire";
		}

		itineraireService.saveItineraire(itineraireAAjouter);
		
		
		redirectAttributes.addFlashAttribute("messageAjoutFormulaire", "Itinéraire ajouté");
		
		return "redirect:/admin/listeItineraires";
	}
	
	//affichage de la page du formulaire de modification d'un itinéraire.
	@GetMapping({"/modifierItineraire/{idItineraire}"})
	public String getModifierItineraire(Model model, @PathVariable("idItineraire") String idItineraire) {
		if(idItineraire == null) {
			model.addAttribute("messageErreurFormulaire", "Un problème est survenu, impossible de savoir quel itinéraire modifier");
			
			return "listeItineraires";
		}else {
			Itineraire itineraireAModifier = itineraireService.getItineraire(Integer.parseInt(idItineraire));
			
			List<Niveau> listeNiveau = getNiveauForm();
			model.addAttribute("listeNiveaux", listeNiveau);
			
			model.addAttribute("itineraireAModifier", itineraireAModifier);
			
		}
		return "modifItineraire";
	}
	
	//validation du formulaire de modification d'un itineraire
	@PostMapping({"/modifierItineraire"})
	public RedirectView postModifierItineraire(Model model, @ModelAttribute("itineraireAModifier") @Valid Itineraire itineraireAModifier, BindingResult result, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		RedirectView redirect = new RedirectView(request.getContextPath() + "/itineraire/" + itineraireAModifier.getIdItineraire());
		redirect.setExposeModelAttributes(false);

		//vérification du niveau de l'itinéraire à part (pour éviter un dto)
		if(!(itineraireAModifier.getNiveauItineraire().getIdNiveau() > 0)) {
			result.addError(new ObjectError("niveauItineraire", "Le niveau est obligatoire"));
		}
		
		//si erreur, retour au formulaire avec les erreurs
		if(result.hasErrors()) {
			redirectAttributes.addFlashAttribute("messageErreurFormulaire", "Merci de vérifier le formulaire, une erreur s'est produite ! Itinéraire non ajouté");
			
			List<Niveau> listeNiveau = getNiveauForm();
			model.addAttribute("listeNiveaux", listeNiveau);
			
			RedirectView redirectError = new RedirectView(request.getContextPath() + "/modifierItineraire/" + itineraireAModifier.getIdItineraire());
			redirectError.setExposeModelAttributes(false);
	    	return redirectError;
		}
		

		itineraireService.saveItineraire(itineraireAModifier);
		
		
		redirectAttributes.addFlashAttribute("messageAjoutFormulaire", "Itinéraire modifié");
		
		return redirect;
	}
	
	@GetMapping({"/supprimer-itineraire/{idItineraire}"})
	public String deleteItineraire(@PathVariable("idItineraire") String idItineraire, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		RedirectView redirect = new RedirectView(request.getContextPath());
		redirect.setExposeModelAttributes(false);
		
		if(idItineraire == null) {
			redirectAttributes.addFlashAttribute("messageErreurFormulaire", "Un problème est survenu, impossible de savoir quel itinéraire modifier");
			
			return "redirect:/admin/listeItineraires";
		}
		
		itineraireService.deleteItineraire(idItineraire);
		
		redirectAttributes.addFlashAttribute("messageAjoutFormulaire", "Itinéraire supprimé !");
		
		return "redirect:/admin/listeItineraires";
		
	}
	
	public List<Niveau> getNiveauForm(){
		List<Niveau> listeNiveau = new ArrayList<Niveau>();
		niveauRepository.findAll().forEach(listeNiveau::add);
		return listeNiveau;
	}
}
