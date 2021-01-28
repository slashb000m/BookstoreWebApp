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

@Entity
public class Avis {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id_avis")
private int id; 

@Temporal(TemporalType.DATE)
@Column(name="date_de_publiation")
private Date datePublication;

private String texte;

@ManyToOne
@JoinColumn(name="id_avis_user")
private User user;




}
