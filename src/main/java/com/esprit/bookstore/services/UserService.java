package com.esprit.bookstore.services;

import java.util.ArrayList;

import com.esprit.bookstore.entities.User;

public interface UserService {
	void ajouterUser(User user);
	boolean Authentification(String email,String Password);
String afficherDonnerPersonnelle(int id);
User getUser(int idUser);
//	void ajouterUser(String nom , String prenom);
}
