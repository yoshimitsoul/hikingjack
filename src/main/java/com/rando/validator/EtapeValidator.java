package com.rando.validator;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.rando.modele.Etape;

@Component
@Service
public class EtapeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Etape.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "nom_etape", "nom.empty");
		ValidationUtils.rejectIfEmpty(errors, "numero_etape", "numero.empty");
		ValidationUtils.rejectIfEmpty(errors, "qrcode_etape", "qrcode.empty");
		ValidationUtils.rejectIfEmpty(errors, "id_itineraire_etape", "itineraire.etape.empty");

		Etape e = (Etape) target;
		if(e.getDescriptionEtape().length() > 2000 ) {
			errors.rejectValue("description_etape", "length_description_toolong");
		}
		

	}

}
