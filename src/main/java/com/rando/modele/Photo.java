package com.rando.modele;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "photo")
public class Photo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_photo")
	private int idPhoto;
	
	@Column(name = "url_photo")
	private String urlPhoto;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_etape")
	private Etape etapePhoto;
	

	public Photo() {
		super();
	}

	public Photo(int idPhoto, String urlPhoto, Etape etapePhoto) {
		super();
		this.idPhoto = idPhoto;
		this.urlPhoto = urlPhoto;
		this.etapePhoto = etapePhoto;
	}

	public Photo(String urlPhoto, Etape etapePhoto) {
		super();
		this.urlPhoto = urlPhoto;
		this.etapePhoto = etapePhoto;
	}

	public int getIdPhoto() {
		return idPhoto;
	}

	public void setIdPhoto(int idPhoto) {
		this.idPhoto = idPhoto;
	}

	public String getUrlPhoto() {
		return urlPhoto;
	}

	public void setUrlPhoto(String urlPhoto) {
		this.urlPhoto = urlPhoto;
	}

	public Etape getEtapePhoto() {
		return etapePhoto;
	}

	public void setEtapePhoto(Etape etapePhoto) {
		this.etapePhoto = etapePhoto;
	}

	@Override
	public String toString() {
		return "Photo [idPhoto=" + idPhoto + ", urlPhoto=" + urlPhoto + ", etapePhoto=" + etapePhoto + "]";
	}
	
	
}
