package com.rando.controleur;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rando.dao.CommentaireRepository;
import com.rando.modele.Commentaire;

/*import com.rando.hikingjack.entites.Commentaire;
import com.rando.hikingjack.repositories.CommentaireRepository;*/

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CommentaireControler {

	@Autowired
	CommentaireRepository commentaireRepository;
	
	@RequestMapping(value = "/commentaires/{id_etape}", method= RequestMethod.GET)
	public ResponseEntity<List<Commentaire>> getListeCommentaireByIdEtape(@PathVariable Integer id_etape){
		List<Commentaire> commentaires = new ArrayList<Commentaire>();

		try {			
			
			commentaireRepository.findByEtapeId(id_etape).forEach(commentaires::add);
			
			if(commentaires.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(commentaires, HttpStatus.OK);
		
		} catch (Exception e) {
			e.printStackTrace();
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@RequestMapping(value = "/ajouter-commentaire", method = RequestMethod.POST)
	public ResponseEntity<String> addCommentaire(@RequestBody Commentaire commentaire){
		try {
			if(commentaire != null) {
				commentaireRepository.save(commentaire);
			}
			return new ResponseEntity<String>(commentaire.toString(), HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/supprimer-commentaire/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Commentaire> deleteCommentaire(@PathVariable int id){
    	try {
			commentaireRepository.deleteById(id);
		}catch (IllegalArgumentException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(HttpStatus.OK);
    }
}
