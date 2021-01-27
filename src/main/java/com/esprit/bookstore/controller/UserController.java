package com.esprit.bookstore.controller;



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.bookstore.entities.Livre;
import com.esprit.bookstore.entities.User;
import com.esprit.bookstore.repositories.UserRepository;
import com.esprit.bookstore.services.UserService;
import com.esprit.bookstore.services.UserServiceImpl;
import com.esprit.bookstore.services.achatService;





@RestController
public class UserController {
	
	@Autowired
	UserService u;
	@Autowired
	UserRepository ur;
	
	@Autowired
	achatService as;

	
	@RequestMapping(value ="/addSouhait/{idLivre}/{idUser}" , produces = "application/json")
	public @ResponseBody String addBookToWishlist(@PathVariable("idUser") Integer idUser, @PathVariable("idLivre") Integer idLivre)
	{
		u.ajouterSouhait(idLivre,idUser);
		
		return "livre ajoutée à la liste des souhaits";
	}
	
	@DeleteMapping("/deleteSouhait")
	public String deleteBookfromwishList()
	{
		u.supprimerSouhait(1,1);
		return " book deleted from wishlist";
		 
	}
	
	@RequestMapping(value = "/getSouhait/{idUser}", produces = "application/json")
	public @ResponseBody List<Livre> afficherDonnerPersonnelle(@PathVariable("idUser") Integer idUser){
   
		List<Livre> l = u.listerSouhait(idUser);
		
		return l;
		
 
}
	
	@RequestMapping(value = "/ajouterAchat/{idUser}/{idLivre}",produces = "application/json")
	public String ajouterAchat(@PathVariable("idUser") Integer idUser, @PathVariable("idLivre") Integer idLivre)
	{
		as.acheterLivre(idUser, idLivre);
		
	
	return "livre acheté";
	}
	

	@RequestMapping(value = "/AR/{percent}/{idLivre}",produces = "application/json")
	public String ajouterreduc(@PathVariable("percent") Integer percent, @PathVariable("idLivre") Integer idLivre)
	{
		
	u.reductionAccord(idLivre, percent)	;
	
	return "reduction acordée";
	}
	

	
}