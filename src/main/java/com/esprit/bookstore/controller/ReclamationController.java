package com.esprit.bookstore.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.bookstore.entities.Reclamation;
import com.esprit.bookstore.services.ReclamationService;
import com.esprit.bookstore.services.ReductionService;
import com.esprit.bookstore.services.StatService;
import com.esprit.bookstore.DAO.*;
import java.util.List;

@RestController
public class ReclamationController {
	
	@Autowired
	ReclamationService reclamationService;

	@Autowired
	StatService statService;

	@Autowired
	ReductionService reductionService; 
	
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

@DeleteMapping("/traiterReclamation")
public void traiterReclamationController(@RequestBody Reclamation reclamation)
{
	reclamationService.traiterReclamation(reclamation);
}




@GetMapping("/stat/CAMensuel")
public List<ChiffreAffaireMensuelI> getStatCA(){
	return statService.getCaService();
}

@GetMapping("/stat/proportionLivre")
public List<LivreVenduParCategorieI> getStatProportionLivreVenduCategorie(){
	return statService.getLivreVenduParCategorie();
	
}

@GetMapping("/get/reclamations")
public List<Reclamation> getReclamations(){
	return reclamationService.getReclamations();
	
}
@PostMapping("/reduction")
public void accorderReduction(@RequestBody AccorderReductionDAO accorderReductionDAO)

{
reductionService.accorderReduction(accorderReductionDAO);	
}


}