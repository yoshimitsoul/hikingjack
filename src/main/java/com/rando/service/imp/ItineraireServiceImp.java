package com.rando.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rando.dao.EtapeRepository;
import com.rando.dao.ItineraireRepository;
import com.rando.modele.Etape;
import com.rando.modele.Itineraire;
import com.rando.service.ItineraireService;

@Service
@Transactional
public class ItineraireServiceImp implements ItineraireService{

	@Autowired
	ItineraireRepository itineraireRepository;
	
	@Autowired
	EtapeRepository etapeRepository;
	
	//récupérer tous les itinéraires et alimenter la liste des étapes de chaque
	@Override
	public List<Itineraire> getItineraireAvecEtapes() {
		List<Itineraire> listeItineraires = new ArrayList<Itineraire>();
		
		itineraireRepository.findAll().forEach(listeItineraires::add);
		
		return listeItineraires;
	}
	
	// récupérer un itinéraire et alimenter ses étapes
	@Override
	public Itineraire getItineraire(int idItineraire) {

		Itineraire itineraire = new Itineraire();
		List<Etape> listeEtapes = new ArrayList<Etape>();
		
		Optional<Itineraire> getItineraire = itineraireRepository.findById(idItineraire);
		itineraire = getItineraire.get();
				
		return itineraire;
	}
	
	@Override
	public void saveItineraire(Itineraire itineraireASauver) {
		itineraireRepository.save(itineraireASauver);
	}
	
	@Override
	public void deleteItineraire(String idItineraire) {
		itineraireRepository.deleteById(Integer.parseInt(idItineraire));
	}
}
