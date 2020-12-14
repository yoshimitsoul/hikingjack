package com.rando.controleur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.rando.modele.Commentaire;
import com.rando.modele.Etape;
import com.rando.modele.Photo;
import com.rando.modele.dtos.CommentaireDto;
import com.rando.service.CommentaireService;
import com.rando.service.EtapeService;
import com.rando.service.PhotoService;



@Controller
public class JspDetailEtapeControleur {

	@Autowired
	EtapeService etapeService;
	
	@Autowired
	CommentaireService commentaireService;
	
	@Autowired
	PhotoService photoService;

	@GetMapping("/detailEtape/{id}")
	public String detailler(Model model, @PathVariable int id) {
		
		Etape etape = etapeService.detaillerEtape(id);
		
		List<Photo> photos = photoService.getAllPhotosByIdEtape(id);
		List<Commentaire> commentaires = commentaireService.getAllCommentsById(id);
		
		model.addAttribute("etape", etape);
		model.addAttribute("photos", photos);
		model.addAttribute("commentaires", commentaires);
		model.addAttribute("ajoutCommentaire", new CommentaireDto());
		return "detailEtapeFront";
	}



	@PostMapping("/detailEtape/{id}")
	public String Like(Model model, @PathVariable int id) {
		
		Etape e =  etapeService.like(id);
		
		model.addAttribute("etape", e);

		return "redirect:/detailEtape/"+ e.getIdEtape();
	}
	
}
