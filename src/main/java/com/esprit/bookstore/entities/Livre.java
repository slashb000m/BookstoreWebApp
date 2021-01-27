package com.esprit.bookstore.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Livre implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "id_livre")
	private int idLivre; 
	
	private String titre; 
	private String auteur; 
	private String categorie;
	
	@Column(name="nbr_pages")
	private int nbrPages; 
	
	@Override
	public String toString() {
		return "Livre [idLivre=" + idLivre + ", titre=" + titre + ", auteur=" + auteur + ", categorie=" + categorie
				+ ", nbrPages=" + nbrPages + ", prix=" + prix + ", type=" + type + ", dateInsertion=]" + dateInsertion ;
	}


	private float prix; 
	
	private String type; 
	
	@Temporal(TemporalType.DATE)
	@Column(name="date_insertion")
	private Date dateInsertion;
	
	@ManyToMany(cascade = CascadeType.ALL)

private Set<User> userSouhait ;
	

	@OneToMany(mappedBy="livreAchat")
	Set<Achat> listeAchat;


	public int getIdLivre() {
		return idLivre;
	}


	public void setIdLivre(int idLivre) {
		this.idLivre = idLivre;
	}


	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public String getAuteur() {
		return auteur;
	}


	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}


	public String getCategorie() {
		return categorie;
	}


	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}


	public int getNbrPages() {
		return nbrPages;
	}


	public void setNbrPages(int nbrPages) {
		this.nbrPages = nbrPages;
	}


	public float getPrix() {
		return prix;
	}


	public void setPrix(float prix) {
		this.prix = prix;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public Date getDateInsertion() {
		return dateInsertion;
	}


	public void setDateInsertion(Date dateInsertion) {
		this.dateInsertion = dateInsertion;
	}


//	public Set<User> getUserSouhait() {
//		return userSouhait;
//	}
//
//
//	public void setUserSouhait(Set<User> userSouhait) {
//		this.userSouhait = userSouhait;
//	}


//	public Set<Achat> getListeAchat() {
//		return listeAchat;
//	}
//
//
//	public void setListeAchat(Set<Achat> listeAchat) {
//		this.listeAchat = listeAchat;
//	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
