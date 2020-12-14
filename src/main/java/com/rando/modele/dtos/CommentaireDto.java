package com.rando.modele.dtos;

import org.hibernate.validator.constraints.NotEmpty;

public class CommentaireDto {
	@NotEmpty(message = "Le pseudo est obligatoire")
	private String pseudo;
	@NotEmpty(message = "Le message est obligatoire")
	private String message;
	private int idEtape;
	
	public CommentaireDto() {
		super();
	}

	public CommentaireDto(String pseudo, String message, int idEtape) {
		super();
		this.pseudo = pseudo;
		this.message = message;
		this.idEtape = idEtape;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getIdEtape() {
		return idEtape;
	}

	public void setIdEtape(int idEtape) {
		this.idEtape = idEtape;
	}
	
	
	
	
}
