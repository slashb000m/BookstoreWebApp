package com.esprit.bookstore.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Livre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_livre")
	private int idLivre; 
	
	private String titre; 
	private String auteur; 
	private String categorie;
	
	@Column(name="nbr_pages")
	private int nbrPages; 
	
	private float prix; 
	
	private String type; 
	
	@Temporal(TemporalType.DATE)
	@Column(name="date_insertion")
	private Date dateInsertion;
	
	@ManyToMany
	Set<User> userSouhait;
	
	@OneToMany(mappedBy="livreAchat")
	Set<Achat> listeAchat;
	
	

}
