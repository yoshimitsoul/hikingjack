package com.rando.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rando.modele.Commentaire;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Integer>{
	
	@Query(value="select c from Commentaire c where c.etapeCommentaire.idEtape = ?1")
	List<Commentaire> findByEtapeId(int idEtape);

}
