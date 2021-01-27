package com.esprit.bookstore.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.bookstore.entities.Reclamation;
import com.esprit.bookstore.entities.User;
import com.esprit.bookstore.services.ReclamationService;

@RestController
public class ReclamationController {
	
	@Autowired
	ReclamationService reclamationService;
	
	
	@PostMapping("/addReclamation")
	public void addReclamationController(@RequestBody Reclamation reclamation)
	
	{
	
		reclamationService.ajouterReclamation(reclamation);
	}
	
@DeleteMapping("/deleteReclamation")
public void deleteReclamationController(@RequestBody Reclamation reclamation)
{
	reclamationService.deleteReclamation(reclamation);
}

}
