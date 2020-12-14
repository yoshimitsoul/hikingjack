package com.rando.modele;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "etape")
public class Etape implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_etape")
	private int idEtape;
	
	@NotEmpty(message = "Le nom est obligatoire")
	@Column(name = "nom_etape")
	private String nomEtape;
	
	@NotNull(message = "Le numéro de l'étape est obligatoire")
	@Min(
	  value = 1,
	  message = "Le numéro de l'étape est obligatoire"
	)
	@Column(name = "numero_etape")
	private int numeroEtape;
	
	@Column(name = "qrcode_etape")
	private String qrCodeEtape;
	
	@Column(name = "description_etape")
	private String descriptionEtape;
	
	@Column(name = "likes_etape")
	private int likesEtape;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_itineraire")
	@JsonIgnore
	private Itineraire itineraireEtape;
	

	public Etape() {
		super();
	}

	public Etape(int idEtape, String nomEtape, int numeroEtape, String qrCodeEtape, String descriptionEtape, int likesEtape,
			Itineraire itineraireEtape) {
		super();
		this.idEtape = idEtape;
		this.nomEtape = nomEtape;
		this.numeroEtape = numeroEtape;
		this.qrCodeEtape = qrCodeEtape;
		this.descriptionEtape = descriptionEtape;
		this.likesEtape = likesEtape;
		this.itineraireEtape = itineraireEtape;
	}

	public Etape(String nomEtape, int numeroEtape, String qrCodeEtape, String descriptionEtape, int likesEtape,
			Itineraire itineraireEtape) {
		super();
		this.nomEtape = nomEtape;
		this.numeroEtape = numeroEtape;
		this.qrCodeEtape = qrCodeEtape;
		this.descriptionEtape = descriptionEtape;
		this.likesEtape = likesEtape;
		this.itineraireEtape = itineraireEtape;
	}

	public int getIdEtape() {
		return idEtape;
	}

	public void setIdEtape(int idEtape) {
		this.idEtape = idEtape;
	}

	public String getNomEtape() {
		return nomEtape;
	}

	public void setNomEtape(String nomEtape) {
		this.nomEtape = nomEtape;
	}

	public int getNumeroEtape() {
		return numeroEtape;
	}

	public void setNumeroEtape(int numeroEtape) {
		this.numeroEtape = numeroEtape;
	}

	public String getQrCodeEtape() {
		return qrCodeEtape;
	}

	public void setQrCodeEtape(String qrCodeEtape) {
		this.qrCodeEtape = qrCodeEtape;
	}

	public String getDescriptionEtape() {
		return descriptionEtape;
	}

	public void setDescriptionEtape(String descriptionEtape) {
		this.descriptionEtape = descriptionEtape;
	}

	public int getLikesEtape() {
		return likesEtape;
	}

	public void setLikesEtape(int likesEtape) {
		this.likesEtape = likesEtape;
	}

	public Itineraire getItineraireEtape() {
		return itineraireEtape;
	}

	public void setItineraireEtape(Itineraire itineraireEtape) {
		this.itineraireEtape = itineraireEtape;
	}

	
	
	
}
