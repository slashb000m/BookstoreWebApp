package com.esprit.bookstore.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id_admin")
private int id;
private String nom; 
private String prenom; 
private String email; 
private String password; 


}
