package com.rando.controleur;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.rando.dao.EtapeRepository;
import com.rando.modele.Etape;
import com.rando.modele.Itineraire;
import com.rando.service.EtapeService;
import com.rando.service.ItineraireService;
import com.rando.validator.EtapeValidator;

@ComponentScan("com.rando.validator")
@Controller
@RequestMapping("/admin")
public class AdminEtapeController {
	
	@Autowired
	EtapeRepository etapeRepository;
	
	@Autowired
	EtapeService etapeService;
	
	@Autowired
	EtapeValidator etapeValidator;
	
	@Autowired
	ItineraireService itineraireService;
	
	//affiche la page de liste d'étapes
	@GetMapping({"/listeEtapes"})
	public String getEtapes(Model model) {
		
		List<Itineraire> listeEtapes = etapeService.getEtapes();
		
		model.addAttribute("listeEtapes", listeEtapes);
		
		return "listeEtapes";
	}
	
	//affiche détail etape
	@GetMapping({"/etape/{idEtape}"})
	public String getEtape(Model model, @PathVariable("idEtape") String idEtape) {
		
		Etape etape = etapeService.getEtape(Integer.parseInt(idEtape));
		System.out.println(etape.toString());
		model.addAttribute("etape", etape);
		
		return "detailEtape";
	}
	
	//affichage de la page du formulaire de création d'une étape.
	@GetMapping({"/creerEtape"})
	public String getAjoutEtape(Model model, @ModelAttribute("ajoutEtape") Etape etapeAAjouter, BindingResult result) {
		if(etapeAAjouter.getIdEtape() > 0) {
			model.addAttribute("etapeAAjouter", etapeAAjouter);
		}else {
			model.addAttribute("etapeAAjouter", new Etape());
		}
		
		List<Itineraire> listeItineraire = itineraireService.getItineraireAvecEtapes();
		model.addAttribute("listeItineraire", listeItineraire);
		
		return "creerEtape";
	}
	
	//validation du formulaire d'ajout d'une étape
	@PostMapping({"/etape-ajout"})
	public String postAjoutEtape(Model model, @ModelAttribute("etapeAAjouter") @Valid Etape etapeAAjouter, BindingResult result, HttpServletRequest request, RedirectAttributes redirectAttributes) {
				
		RedirectView redirect = new RedirectView(request.getContextPath() + "/creerEtape");
		redirect.setExposeModelAttributes(false);
		
		//si erreur, retour au formulaire avec les erreurs
		if(result.hasErrors()) {
			model.addAttribute("messageErreurFormulaire", "Merci de vérifier le formulaire, une erreur s'est produite ! Étape non ajouté");
			
			List<Itineraire> listeItineraire = itineraireService.getItineraireAvecEtapes();
			model.addAttribute("listeItineraire", listeItineraire);
			
			
	    	return "creerEtape";
		}

		try {
			etapeService.saveEtape(etapeAAjouter);
		} catch (Exception e) {
			model.addAttribute("messageErreurFormulaire", "Ce numéro d'étape pour cet itinéraire éxiste déjà, merci de rentrer un numéro d'étape inexistant");
			List<Itineraire> listeItineraire = itineraireService.getItineraireAvecEtapes();
			model.addAttribute("listeItineraire", listeItineraire);
			
			e.printStackTrace();

	    	return "creerEtape";
		}
		
		
		redirectAttributes.addFlashAttribute("messageAjoutFormulaire", "Étape ajoutée");
		
		return "redirect:/admin/listeEtapes";
	}
	
	//affichage de la page du formulaire de modification d'une étape.
	@GetMapping({"/modifier-etape/{idEtape}"})
	public String getModifierEtape(Model model, @PathVariable("idEtape") String idEtape) {
		if(idEtape == null) {
			model.addAttribute("messageErreurFormulaire", "Un problème est survenu, impossible de savoir quelle étape modifier");
			
			return "listeEtapes";
		}else {
			Etape etapeAModifier = etapeService.getEtape(Integer.parseInt(idEtape));
			
			List<Itineraire> listeItineraire = itineraireService.getItineraireAvecEtapes();
			model.addAttribute("listeItineraire", listeItineraire);
			
			model.addAttribute("etapeAModifier", etapeAModifier);
			
		}
		return "modifEtape";
	}
	
	//validation du formulaire de modification d'une étape
	@PostMapping({"/etape-modifier"})
	public String postModifierEtape(Model model, @ModelAttribute("etapeAModifier") @Valid Etape etapeAModifier, BindingResult result, HttpServletRequest request, RedirectAttributes redirectAttributes) {
				
		RedirectView redirect = new RedirectView(request.getContextPath() + "/etape/" + etapeAModifier.getIdEtape());
		redirect.setExposeModelAttributes(false);

		//si erreur, retour au formulaire avec les erreurs
		if(result.hasErrors()) {
			model.addAttribute("messageErreurFormulaire", "Merci de vérifier le formulaire, une erreur s'est produite ! Étape non ajouté");
			
			List<Itineraire> listeItineraire = itineraireService.getItineraireAvecEtapes();
			model.addAttribute("listeItineraire", listeItineraire);
			
			
	    	return "modifEtape";
		}
	
		try {
			etapeService.saveEtape(etapeAModifier);
		} catch (Exception e) {
			model.addAttribute("messageErreurFormulaire", "Ce numéro d'étape pour cet itinéraire éxiste déjà, merci de rentrer un numéro d'étape inexistant");
			List<Itineraire> listeItineraire = itineraireService.getItineraireAvecEtapes();
			model.addAttribute("listeItineraire", listeItineraire);
			
			e.printStackTrace();
	
	    	return "modifEtape";
		}
		
		redirectAttributes.addFlashAttribute("messageAjoutFormulaire", "Étape modifiée");
		
		return "redirect:/admin/listeEtapes";
	}
	
	@GetMapping({"/supprimer-etape/{idEtape}"})
	public String deleteEtape(@PathVariable("idEtape") String idEtape, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		RedirectView redirect = new RedirectView(request.getContextPath());
		redirect.setExposeModelAttributes(false);
		
		if(idEtape == null) {
			redirectAttributes.addFlashAttribute("messageErreurFormulaire", "Un problème est survenu, impossible de savoir quel étape supprimer");
			
			return "redirect:/admin/listeEtapes";
		}
		
		etapeService.deleteEtape(idEtape);
		
		redirectAttributes.addFlashAttribute("messageAjoutFormulaire", "Étape supprimée !");
		
		return "redirect:/admin/listeEtapes";
		
	}
}
