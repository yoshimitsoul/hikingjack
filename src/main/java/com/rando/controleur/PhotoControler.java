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

import com.rando.dao.PhotoRepository;
import com.rando.modele.Etape;
import com.rando.modele.Photo;

/*import com.rando.hikingjack.entites.Etape;
import com.rando.hikingjack.entites.Photo;
import com.rando.hikingjack.repositories.PhotoRepository;*/

@CrossOrigin
@RestController
@RequestMapping("/api")
public class PhotoControler {

	@Autowired
	PhotoRepository photoRepository;
	
	@RequestMapping(value = "/photos/{id_etape}", method= RequestMethod.GET)
	public ResponseEntity<List<Photo>> getListePhotosByIdEtape(@PathVariable Integer id_etape){
		List<Photo> photos = new ArrayList<Photo>();

		try {			
			
			photoRepository.findByEtapeId(id_etape).forEach(photos::add);
			
			if(photos.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(photos, HttpStatus.OK);
		
		} catch (Exception e) {
			e.printStackTrace();
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@RequestMapping(value = "/ajouter-photo", method = RequestMethod.POST)
	public ResponseEntity<String> addPhoto(@RequestBody Photo photo){
		try {
			if(photo != null) {
				photoRepository.save(photo);
			}
			return new ResponseEntity<String>(photo.toString(), HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/supprimer-photo/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Etape> deletePhoto(@PathVariable int id){
    	try {
			photoRepository.deleteById(id);
		}catch (IllegalArgumentException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(HttpStatus.OK);
    }
}
