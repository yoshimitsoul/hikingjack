package com.rando.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rando.modele.Itineraire;

@Repository
@Transactional
public interface ItineraireRepository extends JpaRepository<Itineraire, Integer>{
	
}
