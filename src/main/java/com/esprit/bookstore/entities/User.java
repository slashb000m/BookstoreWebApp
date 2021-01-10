package com.esprit.bookstore.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	@Column(name="id_user")
	private int idUser; 
	
	private String nom;
	private String prenom;
	private String email ; 
	private String password;
	
	@Column(name="date_inscription")
	@Temporal(TemporalType.DATE)	
    private Date dateInscription; 
	
	@Column(name="auteur_prefere")
	private String auteurPrefere; 
	
	@Column(name="genre_prefere")
	private String genrePrefere;
	
	@Enumerated(EnumType.STRING)
	private Statut statut; 
 
	
	public enum Statut{
		Etudiant,Enseignant,Autre
	}
	
	/*@ManyToMany
	@JoinTable(
			  name = "souhaits")
    Set<Livre> livreSouhaite;*/
	
	@OneToMany(mappedBy="user")
	private Set<Avis> listeAvis; 
	
	@OneToMany(mappedBy="userAchat")
	private Set<Achat> listeAchats;
	
	@OneToMany(mappedBy="userReclamation")
	private Set<Reclamation> listeReclamation;

	
	

}
