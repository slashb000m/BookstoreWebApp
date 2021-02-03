package tn.esprit.spring.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "livres")
public class Livre {
	@Id
	@GeneratedValue
	private int id_livre;
	private String titre;
	private String auteur;
	private String categorie;
	private String description;
	private String type;
	private float prix;
	private int nombrep;
	private String chemin;
	private String image;
	private Date date;

	public Livre() {
		super();
	}

	
	
	public Livre(int id_livre, String titre, String auteur, String categorie, String description, String type,
			float prix, int nombrep, String chemin, String image, Date date) {
		super();
		this.id_livre = id_livre;
		this.titre = titre;
		this.auteur = auteur;
		this.categorie = categorie;
		this.description = description;
		this.type = type;
		this.prix = prix;
		this.nombrep = nombrep;
		this.chemin = chemin;
		this.image = image;
		this.date = date;
	}



	public int getId_livre() {
		return id_livre;
	}

	public void setId_livre(int id_livre) {
		this.id_livre = id_livre;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public int getNombrep() {
		return nombrep;
	}

	public void setNombrep(int nombrep) {
		this.nombrep = nombrep;
	}

	public String getChemin() {
		return chemin;
	}

	public void setChemin(String chemin) {
		this.chemin = chemin;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


}
