package com.esprit.bookstore.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.esprit.bookstore.entities.User;

public interface UserService {
	//void ajouterUser(User user);
//	boolean Authentification(String email,String Password);
//String afficherDonnerPersonnelle(int id);
//User getUser(int idUser);
 //User getUserByUsername(String username);
//	void ajouterUser(String nom , String prenom);
 
 public User getUserById(int id);
 public List<User> getAllUsers();
 public User addUser(User user)throws Exception;
 public User addAdmin(User user)throws Exception;
// public User deleteUser(int userId);
 public User updateUserName(int userId, User user);
}
