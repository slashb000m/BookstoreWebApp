package com.esprit.bookstore.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Admin implements Serializable {

	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue
@Column(name="id_admin")
private int id;

private String nom; 
private String prenom; 
private String email; 
private String password; 


}
