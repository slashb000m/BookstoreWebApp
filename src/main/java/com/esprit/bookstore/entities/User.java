package com.esprit.bookstore.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class User {
	
	
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
    private java.util.Date dateInscription; 
	
	public User(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	public User(int idUser, String nom, String prenom, String email, String password, java.sql.Date dateInscription,
			String auteurPrefere, String genrePrefere, Statut statut) {
		super();
		this.idUser = idUser;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.dateInscription = dateInscription;
		this.auteurPrefere = auteurPrefere;
		this.genrePrefere = genrePrefere;
		this.statut = statut;
	}

	@Column(name="auteur_prefere")
	private String auteurPrefere; 
	
	@Column(name="genre_prefere")
	private String genrePrefere;
	
	@Enumerated(EnumType.STRING)
	private Statut statut; 
	
	
	
	
	public User() {
		super();
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

	public java.util.Date getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(java.sql.Date dateInscription) {
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

	public User(int idUser, String nom, String prenom, String email, String password, Date dateInscription,
			String auteurPrefere, String genrePrefere, Statut statut) {
		super();
		this.idUser = idUser;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.dateInscription = dateInscription;
		this.auteurPrefere = auteurPrefere;
		this.genrePrefere = genrePrefere;
		this.statut = statut;
	}

	@Override
	public String toString() {
		return "[User [idUser =" + idUser +"\n" + 
	", nom =" + nom +"\n" +
	", prenom =" + prenom +"\n" + 
	", email =" + email +"\n"+
	", password = password  " +"\n"
	+", dateInscription =" + dateInscription +"\n"+ 
	", auteurPrefere =" + auteurPrefere +"\n"+
				 ", genrePrefere=" + genrePrefere  +"\n" +
				", statut =" + statut +"\n"+ 
				", listeAvis =" + listeAvis+"\n"
				+ ", listeAchats =" + listeAchats +"\n"+ 
				", listeReclamation =" + listeReclamation + "]";
	}

	
	

}
