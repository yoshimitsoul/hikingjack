package com.rando.modele;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;

@Entity
@Table(name = "securite_user")
@Scope("session")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_user")
	private int idUser;
	
	@Column(name = "nom_user")
	private String nomUser;
	
	@Column(name = "pass_user")
	private String passUser;
	
	@Column(name = "role_user")
	private String roleUser;
	
	

	public User() {
		super();
	}

	public User(int idUser, String nomUser, String passUser, String roleUser) {
		super();
		this.idUser = idUser;
		this.nomUser = nomUser;
		this.passUser = passUser;
		this.roleUser = roleUser;
	}

	public User(String nomUser, String passUser, String roleUser) {
		super();
		this.nomUser = nomUser;
		this.passUser = passUser;
		this.roleUser = roleUser;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getNomUser() {
		return nomUser;
	}

	public void setNomUser(String nomUser) {
		this.nomUser = nomUser;
	}

	public String getPassUser() {
		return passUser;
	}

	public void setPassUser(String passUser) {
		this.passUser = passUser;
	}

	public String getRoleUser() {
		return roleUser;
	}

	public void setRoleUser(String roleUser) {
		this.roleUser = roleUser;
	}

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", nomUser=" + nomUser + ", passUser=" + passUser + ", roleUser=" + roleUser
				+ "]";
	}
	
	

}
