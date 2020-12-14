package com.rando.service;

import java.util.List;
import java.util.Optional;

import com.rando.modele.Etape;
import com.rando.modele.Itineraire;

public interface EtapeService {

	void modifier(Etape etape);
	
	List<Etape> getAllEtapes();
	
	Optional<Etape> getOneEtape(int id);
	
	Etape like(int id);
	
	Etape detaillerEtape(int id);

	List<Itineraire> getEtapes();

	Etape getEtape(int idEtape);

	void saveEtape(Etape etapeASauver) throws Exception;

	void deleteEtape(String idEtape);
}
