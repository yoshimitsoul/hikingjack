package com.rando.controleur;

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

import com.rando.dao.EtapeRepository;
import com.rando.modele.Etape;

/*import com.rando.hikingjack.entites.Etape;
import com.rando.hikingjack.entites.Itineraire;
import com.rando.hikingjack.repositories.EtapeRepository; */

@CrossOrigin
@RestController
@RequestMapping("/api")
public class EtapeControler {

	@Autowired
	EtapeRepository etapeRepository;
	
	@RequestMapping(value = "/etapes", method= RequestMethod.GET)
	public ResponseEntity<List<Etape>> getListeEtapes(){
		try {
			List<Etape> etapes = new ArrayList<Etape>();
			
			etapeRepository.findAll().forEach(etapes::add);
			
			if(etapes.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(etapes, HttpStatus.OK);
		
		} catch (Exception e) {
			e.printStackTrace();
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@RequestMapping(value = "/etape/{id}", method= RequestMethod.GET)
	public ResponseEntity<Optional<Etape>> getEtape(@PathVariable Integer id){
		try {
			Optional<Etape> etape;
			
			if(id > 0) {
				etape = etapeRepository.findById(id);
			}else {
				etape = null;
			}
			
			//if(etape.isEmpty())
			if(etape == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(etape, HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
		    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@RequestMapping(value = "/ajouter-etape", method = RequestMethod.POST)
	public ResponseEntity<String> addEtape(@RequestBody Etape etape){
		try {
			if(etape != null) {
				etapeRepository.save(etape);
			}
			return new ResponseEntity<String>(etape.toString(), HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/supprimer-etape/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Etape> deleteEtape(@PathVariable int id){
    	try {
			etapeRepository.deleteById(id);
		}catch (IllegalArgumentException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(HttpStatus.OK);
    }
}
