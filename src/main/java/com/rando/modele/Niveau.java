package com.rando.modele;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "niveau")
public class Niveau implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_niveau")
	private int idNiveau;
	
	@Column(name = "libelle_niveau")
	private String libelleNiveau;
	
	

	public Niveau() {
		super();
	}

	public Niveau(String libelleNiveau) {
		super();
		this.libelleNiveau = libelleNiveau;
	}

	public Niveau(int idNiveau, String libelleNiveau) {
		super();
		this.idNiveau = idNiveau;
		this.libelleNiveau = libelleNiveau;
	}

	public int getIdNiveau() {
		return idNiveau;
	}

	public void setIdNiveau(int idNiveau) {
		this.idNiveau = idNiveau;
	}

	public String getLibelleNiveau() {
		return libelleNiveau;
	}

	public void setLibelleNiveau(String libelleNiveau) {
		this.libelleNiveau = libelleNiveau;
	}

	@Override
	public String toString() {
		return "Niveau [idNiveau=" + idNiveau + ", libelleNiveau=" + libelleNiveau + "]";
	}

	
	
}
