package com.esprit.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.esprit.bookstore.entities.User;
import com.esprit.bookstore.services.UserService;
@Controller
@RestController
public class UserController {
	
	
		
		@Autowired
		UserService userService;
		
		
		@PostMapping("/addUser")
		
		public void addUser(@RequestBody User user)
		
		{
		
			userService.ajouterUser(user);
		}
//		@GetMapping("/authentification")
//		public boolean Authentification(@RequestBody String email,@RequestBody String Password){
//			return userService.Authentification(email, Password);
//		}
//	
				@PostMapping("/getUser")
//		@Produces(MediaType.APPLICATION_JSON)
//		@Consumes(MediaType.APPLICATION_JSON)
		@RequestMapping(value = "/getuser/{idUser}", produces = "application/json")
		public @ResponseBody String afficherDonnerPersonnelle(@PathVariable Integer idUser){
			
			String userData = userService.afficherDonnerPersonnelle(idUser);
			return userData;
			
		}
}
