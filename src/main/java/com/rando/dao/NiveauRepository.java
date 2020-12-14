package com.rando.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rando.modele.Niveau;

@Repository
public interface NiveauRepository extends JpaRepository<Niveau, Integer>{

}
