package com.rando.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rando.modele.Etape;
import com.rando.modele.Photo;

@Repository
public interface EtapeRepository extends JpaRepository<Etape, Integer>{
	
	@Transactional
	@Modifying
	@Query(value="DELETE FROM Etape e WHERE e.idEtape = ?1")
	public void deleteByEtapeId(int idEtape);
}
