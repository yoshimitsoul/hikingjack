package com.rando.service.imp;

import java.util.Calendar;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rando.dao.CommentaireRepository;
import com.rando.dao.EtapeRepository;
import com.rando.modele.Commentaire;
import com.rando.modele.Etape;
import com.rando.modele.dtos.CommentaireDto;
import com.rando.service.CommentaireService;

@Service
@Transactional
public class CommentaireServiceImp implements CommentaireService{
	
	@Autowired
	CommentaireRepository commentaireRepository;
	
	@Autowired
	EtapeRepository etapeRepository;

	// create a java calendar instance
	Calendar calendar = Calendar.getInstance();

	// get a java date (java.util.Date) from the Calendar instance.
	// this java date will represent the current date, or "now".
	java.util.Date currentDate = calendar.getTime();

	// now, create a java.sql.Date from the java.util.Date
	java.sql.Date date = new java.sql.Date(currentDate.getTime());
	
	public List<Commentaire> getAllCommentsById(int id) {
		// TODO Auto-generated method stub
		return commentaireRepository.findByEtapeId(id);
	}

	@Override
	public void addCommentaire(CommentaireDto c) {
		Etape etapeCommentaire = null;
		Optional<Etape> etape = etapeRepository.findById(c.getIdEtape());
		if(!etape.isEmpty()) {
			etapeCommentaire = etape.get();
		}else {
			throw new NoSuchElementException();
		}
		
		Commentaire commentaire = new Commentaire();
		
		// c.setEtapeCommentaire(etapeCommentaire);
		
		commentaire.setMessageCommentaire(c.getMessage());
		commentaire.setEtapeCommentaire(etapeCommentaire);
		commentaire.setPseudoCommentaire(c.getPseudo());
		commentaire.setDateCommentaire(date);
	
		
		
		commentaireRepository.save(commentaire);
		
	}
	
	

	

	

	
	
	

}
