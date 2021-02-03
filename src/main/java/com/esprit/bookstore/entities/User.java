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
	@Column(unique= true)
	private String username;
	private String prenom;
	private String nom;
	@Column(unique=true)
	private String email ; 
	private String password;
	private String role;

	@Column(name="auteur_prefere")
	private String auteurPrefere; 
	
	@Column(name="genre_prefere")
	private String genrePrefere;
	
	@Enumerated(EnumType.STRING)
	private Statut statut; 
	
	
	
	public User(String username, String nom, String email, String password,String role) {
		super();
		this.username = username;
		this.nom = nom;
		this.email = email;
		this.password = password;
		this.role = role;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public User(String username, String prenom, String nom, String email, String password, String role,
			Date dateInscription, String auteurPrefere, String genrePrefere, Statut statut) {
		super();
		this.username = username;
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.password = password;
		this.role = role;
		this.dateInscription = dateInscription;
		this.auteurPrefere = auteurPrefere;
		this.genrePrefere = genrePrefere;
		this.statut = statut;
	}

	

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Column(name="date_inscription")
	@Temporal(TemporalType.DATE)	
    private java.util.Date dateInscription; 
	
	public User(String nom, String prenom) {
		super();
		this.username = nom;
		this.prenom = prenom;
	}

	public User(String username, String prenom, String email, String password, String role, Date dateInscription,
			String auteurPrefere, String genrePrefere, Statut statut) {
		super();
		this.username = username;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.role = role;
		this.dateInscription = dateInscription;
		this.auteurPrefere = auteurPrefere;
		this.genrePrefere = genrePrefere;
		this.statut = statut;
	}

	public User(int idUser, String nom, String prenom, String email, String password, java.sql.Date dateInscription,
			String auteurPrefere, String genrePrefere, Statut statut) {
		super();
		this.idUser = idUser;
		this.username = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.dateInscription = dateInscription;
		this.auteurPrefere = auteurPrefere;
		this.genrePrefere = genrePrefere;
		this.statut = statut;
	}

	
	
	
	public User() {
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

	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
		this.username = nom;
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
	", nom =" + username +"\n" +
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
