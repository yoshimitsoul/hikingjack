package com.rando.service;

import java.util.List;

import com.rando.modele.Commentaire;
import com.rando.modele.dtos.CommentaireDto;

public interface CommentaireService {

	List<Commentaire> getAllCommentsById(int id);
	
	void addCommentaire(CommentaireDto c);

}
