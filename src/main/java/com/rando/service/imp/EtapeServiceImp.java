package com.rando.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rando.dao.EtapeRepository;
import com.rando.dao.ItineraireRepository;
import com.rando.modele.Etape;
import com.rando.modele.Itineraire;
import com.rando.service.EtapeService;

@Service
@Transactional
public class EtapeServiceImp implements EtapeService{
	
	@Autowired
	EtapeRepository etapeRepository;
	
	@Autowired
	ItineraireRepository itineraireRepository;

	//récupérer toutes les étapes
	@Override
	public List<Itineraire> getEtapes() {
		List<Etape> listeEtapes = new ArrayList<Etape>();
		List<Itineraire> listeItineraire = new ArrayList<Itineraire>();
		
		itineraireRepository.findAll().forEach(listeItineraire::add);
		etapeRepository.findAll().forEach(listeEtapes::add);
		
		return listeItineraire;
	}
	
	// récupérer une étape
	@Override
	public Etape getEtape(int idEtape) {
		
		Optional<Etape> getEtape = etapeRepository.findById(idEtape);
		Etape etape = getEtape.get();
	
		return etape;
	}
	
	@Override
	public void saveEtape(Etape etapeASauver) throws Exception {
		List<Etape> listeEtapes = etapeRepository.findAll();
		for(Etape e : listeEtapes) {
			if(e.getItineraireEtape().getIdItineraire() ==  etapeASauver.getItineraireEtape().getIdItineraire() && e.getNumeroEtape() == etapeASauver.getNumeroEtape()) {
				throw new Exception("Numéro d'étape existe déjà");
			}
		}
		etapeRepository.save(etapeASauver);
	}
	
	@Override
	public void deleteEtape(String idEtape) {
		etapeRepository.deleteByEtapeId(Integer.parseInt(idEtape));
	}
	
	
	
	//services pour le front 
	@Override
	public void modifier(Etape etape) {
		// TODO Auto-generated method stub
		try {

			etapeRepository.save(etape);

		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

	@Override
	public List<Etape> getAllEtapes() {

		return etapeRepository.findAll();
	}

	@Override
	public Optional<Etape> getOneEtape(int id) {
		// TODO Auto-generated method stub
		return etapeRepository.findById(id);
	}

	@Override
	public Etape like(int id) {
		
		Etape e = null;
		Optional<Etape> etape = etapeRepository.findById(id);
		
		if(!etape.isEmpty()) {
			e = etape.get();
		}else {
			throw new NoSuchElementException();
		}

		int x = e.getLikesEtape();
		++x;

		e.setLikesEtape(x);
		
		etapeRepository.save(e);
		return e;
	}

	@Override
	public Etape detaillerEtape(int id) {
		
		Optional<Etape> e = this.getOneEtape(id);
		
		Etape etape = e.get();
		
		return etape;
		
	}
}
