package com.rando.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rando.modele.Photo;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Integer>{
	
	@Query(value="select p from Photo p where p.etapePhoto.idEtape = ?1")
	List<Photo> findByEtapeId(int idEtape);
	
}
