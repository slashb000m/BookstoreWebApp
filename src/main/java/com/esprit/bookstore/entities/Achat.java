package com.esprit.bookstore.entities;

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
public class Achat {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id_achat")
private int idAchat;

@Column(name="prix_dachat")
private float prixAchat;

@ManyToOne
@JoinColumn(name="id_user_achat")
private User userAchat;

@ManyToOne
@JoinColumn(name="id_livre_achat")
private Livre livreAchat;

@Temporal(TemporalType.DATE)
@Column(name="date_achat")
private Date date;




	

}
