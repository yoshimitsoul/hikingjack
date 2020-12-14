package com.rando.modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;



@Entity
@Table(name = "itineraire")
public class Itineraire implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_itineraire")
	private int idItineraire;
	
	@NotEmpty(message = "Le nom est obligatoire")
	@Column(name = "nom_itineraire")
	private String nomItineraire;
		
	@ManyToOne(cascade={CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name = "niveau_itineraire")
	private Niveau niveauItineraire;
	
//	@Transient
	@OneToMany(mappedBy="itineraireEtape", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@OrderBy("numeroEtape")
	private List<Etape> listeEtapesItineraire = new ArrayList<Etape>();

	public Itineraire() {
		super();
	}

	public Itineraire(int idItineraire, String nomItineraire, String descriptionItineraire, Niveau niveauItineraire) {
		super();
		this.idItineraire = idItineraire;
		this.nomItineraire = nomItineraire;
		this.niveauItineraire = niveauItineraire;
	}

	public Itineraire(String nomItineraire, String descriptionItineraire, Niveau niveauItineraire) {
		super();
		this.nomItineraire = nomItineraire;
		this.niveauItineraire = niveauItineraire;
	}
	
	

	public Itineraire(int idItineraire, String nomItineraire, Niveau niveauItineraire,
			List<Etape> listeEtapesItineraire) {
		super();
		this.idItineraire = idItineraire;
		this.nomItineraire = nomItineraire;
		this.niveauItineraire = niveauItineraire;
		this.listeEtapesItineraire = listeEtapesItineraire;
	}

	public int getIdItineraire() {
		return idItineraire;
	}

	public void setIdItineraire(int idItineraire) {
		this.idItineraire = idItineraire;
	}

	public String getNomItineraire() {
		return nomItineraire;
	}

	public void setNomItineraire(String nomItineraire) {
		this.nomItineraire = nomItineraire;
	}

	

	public Niveau getNiveauItineraire() {
		return niveauItineraire;
	}

	public void setNiveauItineraire(Niveau niveauItineraire) {
		this.niveauItineraire = niveauItineraire;
	}
	
	

	public List<Etape> getListeEtapesItineraire() {
		return listeEtapesItineraire;
	}

	public void setListeEtapesItineraire(List<Etape> listeEtapesItineraire) {
		this.listeEtapesItineraire = listeEtapesItineraire;
	}

	@Override
	public String toString() {
		return "Itineraire [idItineraire=" + idItineraire + ", nomItineraire=" + nomItineraire + ", niveauItineraire="
				+ niveauItineraire + ", listeEtapesItineraire=" + listeEtapesItineraire + "]";
	}

	
	
}
