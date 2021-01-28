package com.esprit.bookstore.services;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esprit.bookstore.entities.Statut;
import com.esprit.bookstore.entities.User;
import com.esprit.bookstore.repositories.UserRepository;
@Service
public class UserServiceImpl implements UserService {
	private static User CurrentUser = new User(); 
	public static User getCurrentUser() {
		return CurrentUser;
	}

	public static void setCurrentUser(User currentUser) {
		CurrentUser = currentUser;
	}
@Autowired
UserRepository userRepository;

	@Override
	public void ajouterUser(User user) {
	 String nom = user.getNom();
	 String prenom = user.getPrenom();
	 String password = user.getPassword();
	 String email = user.getEmail();
	 String statut = user.getStatut().toString();
	 String autpref = user.getAuteurPrefere();
	 String genpref = user.getGenrePrefere();
	 
//		String nom = "maa";
//		String prenom = "maa";
	 long millis=System.currentTimeMillis();

 java.sql.Date date=new java.sql.Date(millis);

	
			userRepository.addUser(autpref, date, email, genpref, prenom, password, prenom,statut, 2 );
		
	}

//	@Override
//	public boolean Authentification(String email, String Password) {
	//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public ArrayList<String> afficherDonnerPersonnelle() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public User getUser(int idUser) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void ajouterUser(String nom, String prenom) {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	public boolean Authentification(String email, String Password) {
		if( userRepository.isAuthenticated(email, Password).equals(null)) {return false ; }
		 else{
		 CurrentUser = getUser(userRepository.recevoireEmployeeParId(email, Password));
			 return true ;
		 
		 }
	}
//
	@Override
	public String afficherDonnerPersonnelle(int id) {
		
		User e = userRepository.findById(id).get();
	return e.toString()	;	
	}
//
	@Override
	public User getUser(int idUser) {
		
		User user =	userRepository.findById(idUser).get();
		return user;
	}
	

}
