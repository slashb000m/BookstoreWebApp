package com.esprit.bookstore.services;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.bookstore.entities.Reclamation;
import com.esprit.bookstore.repositories.ReclamationRepository;

@Service
public class ReclamationServiceImpl implements ReclamationService{

	 @Autowired 
	 ReclamationRepository reclamationRepository;
	 
	 @Override
	public void ajouterReclamation(Reclamation reclamation) {
		String titre = reclamation.getTitre();
		String texte = reclamation.getTexte();
		int userId = 1;
		java.util.Date date=new java.util.Date();  
		
		reclamationRepository.addReclamation(titre, texte, date, userId);
		
		
		
	}

	@Override
	public void deleteReclamation(Reclamation reclamation) {
		
		int id = reclamation.getId();		
		reclamationRepository.deleteById(id);
		
		
	}
	
	
	   



}
