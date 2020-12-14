package com.rando.validator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.rando.dao.NiveauRepository;
import com.rando.modele.Itineraire;
import com.rando.modele.Niveau;

@Component
@Service
public class ItineraireValidator implements Validator {
	
	@Autowired
	NiveauRepository niveauRepository;
	
	

	@Override
	public boolean supports(Class<?> clazz) {
		return Itineraire.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "nomItineraire", "Le nom est obligatoire");
		Itineraire i = (Itineraire) target;
		Optional<Niveau> niveauAAjouter = niveauRepository.findById(i.getNiveauItineraire().getIdNiveau());
		if(niveauAAjouter == null || niveauAAjouter.isEmpty()) {
			System.out.println("pas de niveau");
			errors.rejectValue("niveauItineraire", "Le niveau est obligatoire");
		}else {
			System.out.println("niveau ok");
			i.setNiveauItineraire(niveauAAjouter.get());
		}
		if(i.getNiveauItineraire() == null) {
			System.out.println("pas de niveau");
			errors.rejectValue("niveauItineraire", "Le niveau est obligatoire");
		}
	}
}
