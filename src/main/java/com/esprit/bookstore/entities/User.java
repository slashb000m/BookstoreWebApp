package com.esprit.bookstore.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class User implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
 
	@ManyToMany(mappedBy="userSouhait" , cascade = CascadeType.ALL)
    Set<Livre> livreSouhaite ;
	
	public enum Statut{
		Etudiant,Enseignant,Autre
	}
	
	
	
	public User() {
		super();
	}

	
	
	

	

	public Set<Livre> getLivreSouhaite() {
		return livreSouhaite;
	}

	public void setLivreSouhaite(Set<Livre> livreSouhaite) {
		this.livreSouhaite = livreSouhaite;
	}







	@OneToMany(mappedBy="user")
	private Set<Avis> listeAvis; 
	
	@OneToMany(mappedBy="userAchat")
	private Set<Achat> listeAchats;
	
	@OneToMany(mappedBy="userReclamation")
	private Set<Reclamation> listeReclamation;

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}

	public String getAuteurPrefere() {
		return auteurPrefere;
	}

	public void setAuteurPrefere(String auteurPrefere) {
		this.auteurPrefere = auteurPrefere;
	}

	public String getGenrePrefere() {
		return genrePrefere;
	}

	public void setGenrePrefere(String genrePrefere) {
		this.genrePrefere = genrePrefere;
	}

	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	public Set<Avis> getListeAvis() {
		return listeAvis;
	}

	public void setListeAvis(Set<Avis> listeAvis) {
		this.listeAvis = listeAvis;
	}

	public Set<Achat> getListeAchats() {
		return listeAchats;
	}

	public void setListeAchats(Set<Achat> listeAchats) {
		this.listeAchats = listeAchats;
	}

	public Set<Reclamation> getListeReclamation() {
		return listeReclamation;
	}

	public void setListeReclamation(Set<Reclamation> listeReclamation) {
		this.listeReclamation = listeReclamation;
	}

	
	

}
