package com.esprit.bookstore.entities;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties
@Entity
public class Reclamation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="reclamation_id")
	private int id; 
	
	



	


	public Reclamation() {
		super();
	}

	private String titre; 
	private String texte; 
    
	@Temporal(TemporalType.TIME)
    @Column(name="date_creation")
	private Date dateCreation;
	
	
	@ManyToOne
    @JoinColumn(name="user_reclamation_id")
	private User userReclamation;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public User getUserReclamation() {
		return userReclamation;
	}

	public void setUserReclamation(User userReclamation) {
		this.userReclamation = userReclamation;
	}

}
