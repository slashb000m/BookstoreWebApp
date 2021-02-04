package com.esprit.bookstore.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.esprit.bookstore.entities.MyUserDetails;
import com.esprit.bookstore.entities.User;

public interface UserService {
	//void ajouterUser(User user);
//	boolean Authentification(String email,String Password);

//User getUser(int idUser);
 //User getUserByUsername(String username);
//	void ajouterUser(String nom , String prenom);
 public	User afficherDonnerPersonnelle(String userName);
 public User getUserById(int id);
 public List<User> getAllUsers();
 public User addUser(User user)throws Exception;
 public User addAdmin(User user)throws Exception;
 public User updateProfile(int id, User user);
 public boolean signIn(String userName,String password);
//public User deleteUser(int userId);
// public ResponseEntity login(MyUserDetails loginRequest) ;
// public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
