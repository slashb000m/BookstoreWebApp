package com.esprit.bookstore.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Achat implements Serializable {

	
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id_achat")
private int idAchat;

@Column(name="prix_dachat")
private float prixAchat;

@ManyToOne
@JoinColumn(name="id_user_achat")
private User userAchat;

public int getIdAchat() {
	return idAchat;
}

public void setIdAchat(int idAchat) {
	this.idAchat = idAchat;
}

public float getPrixAchat() {
	return prixAchat;
}

public void setPrixAchat(float prixAchat) {
	this.prixAchat = prixAchat;
}

public User getUserAchat() {
	return userAchat;
}

public void setUserAchat(User userAchat) {
	this.userAchat = userAchat;
}

public Livre getLivreAchat() {
	return livreAchat;
}

public void setLivreAchat(Livre livreAchat) {
	this.livreAchat = livreAchat;
}

public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}

@ManyToOne
@JoinColumn(name="id_livre_achat")
private Livre livreAchat;

@Temporal(TemporalType.DATE)
@Column(name="date_achat")
private Date date;




	

}
