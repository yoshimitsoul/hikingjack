package com.rando.modele;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "commentaire")
public class Commentaire implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_commentaire")
	private int idCommentaire;
	
	@Column(name = "pseudo_commentaire")
	private String pseudoCommentaire;
	
	@Column(name = "message_commentaire")
	private String messageCommentaire;
	
	@Column(name = "date_commentaire")
	private Date dateCommentaire;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_etape")
	private Etape etapeCommentaire;
	
	

	public Commentaire() {
		super();
	}

	public Commentaire(int idCommentaire, String pseudoCommentaire, String messageCommentaire, Date dateCommentaire,
			Etape etapeCommentaire) {
		super();
		this.idCommentaire = idCommentaire;
		this.pseudoCommentaire = pseudoCommentaire;
		this.messageCommentaire = messageCommentaire;
		this.dateCommentaire = dateCommentaire;
		this.etapeCommentaire = etapeCommentaire;
	}

	public Commentaire(String pseudoCommentaire, String messageCommentaire, Date dateCommentaire,
			Etape etapeCommentaire) {
		super();
		this.pseudoCommentaire = pseudoCommentaire;
		this.messageCommentaire = messageCommentaire;
		this.dateCommentaire = dateCommentaire;
		this.etapeCommentaire = etapeCommentaire;
	}

	public int getIdCommentaire() {
		return idCommentaire;
	}

	public void setIdCommentaire(int idCommentaire) {
		this.idCommentaire = idCommentaire;
	}

	public String getPseudoCommentaire() {
		return pseudoCommentaire;
	}

	public void setPseudoCommentaire(String pseudoCommentaire) {
		this.pseudoCommentaire = pseudoCommentaire;
	}

	public String getMessageCommentaire() {
		return messageCommentaire;
	}

	public void setMessageCommentaire(String messageCommentaire) {
		this.messageCommentaire = messageCommentaire;
	}

	public Date getDateCommentaire() {
		return dateCommentaire;
	}

	public void setDateCommentaire(Date dateCommentaire) {
		this.dateCommentaire = dateCommentaire;
	}

	public Etape getEtapeCommentaire() {
		return etapeCommentaire;
	}

	public void setEtapeCommentaire(Etape etapeCommentaire) {
		this.etapeCommentaire = etapeCommentaire;
	}

	@Override
	public String toString() {
		return "Commentaire [idCommentaire=" + idCommentaire + ", pseudoCommentaire=" + pseudoCommentaire
				+ ", messageCommentaire=" + messageCommentaire + ", dateCommentaire=" + dateCommentaire
				+ ", etapeCommentaire=" + etapeCommentaire + "]";
	}
	
	
}
