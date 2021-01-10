package com.esprit.bookstore.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reclamation {
	
	@Id
	@GeneratedValue
	@Column(name="reclamation_id")
	private int id; 
	
	private String titre; 
	private String texte; 
    
	@Temporal(TemporalType.TIME)
    @Column(name="date_creation")
	private Date dateCreation;
	
	@ManyToOne
    @JoinColumn(name="user_reclamation_id")
	private User userReclamation;

}
