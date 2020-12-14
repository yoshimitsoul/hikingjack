package com.rando.service;

import java.util.List;

import com.rando.modele.Itineraire;

public interface ItineraireService {

	void deleteItineraire(String idItineraire);

	List<Itineraire> getItineraireAvecEtapes();

	Itineraire getItineraire(int idItineraire);

	void saveItineraire(Itineraire itineraireASauver);

}
