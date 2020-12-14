package com.rando.controleur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rando.dao.ItineraireRepository;
import com.rando.modele.Itineraire;

/*import com.rando.hikingjack.entites.Itineraire;
import com.rando.hikingjack.repositories.ItineraireRepository;*/

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ItineraireControler {

	@Autowired
	ItineraireRepository itineraireRepository;
	
	@RequestMapping(value = "/itineraires", method= RequestMethod.GET)
	public ResponseEntity<List<Itineraire>> getListeItineraires(){
		try {
			List<Itineraire> itineraires = new ArrayList<Itineraire>();
			
			itineraireRepository.findAll().forEach(itineraires::add);
			
			if(itineraires.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(itineraires, HttpStatus.OK);
		
		} catch (Exception e) {
			e.printStackTrace();
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@RequestMapping(value = "/itineraire/{id}", method= RequestMethod.GET)
	public ResponseEntity<Optional<Itineraire>> getItineraire(@PathVariable Integer id){
		try {
			Optional<Itineraire> itineraire;
			
			if(id > 0) {
				itineraire = itineraireRepository.findById(id);
			}else {
				itineraire = null;
			}
			
			//if(itineraire.isEmpty())
			if(itineraire == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(itineraire, HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
		    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@RequestMapping(value = "/ajouter-itineraire", method = RequestMethod.POST)
	public ResponseEntity<String> addItineraire(@RequestBody Itineraire itineraire){
		try {
			if(itineraire != null) {
				itineraireRepository.save(itineraire);
			}
			return new ResponseEntity<String>(itineraire.toString(), HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
    @RequestMapping(value="/supprimer-itineraire/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Itineraire> deleteItineraire(@PathVariable int id){
    	try {
			itineraireRepository.deleteById(id);
		}catch (IllegalArgumentException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(HttpStatus.OK);
    }
}
