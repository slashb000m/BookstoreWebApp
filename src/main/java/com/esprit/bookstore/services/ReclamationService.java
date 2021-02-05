package com.esprit.bookstore.services;

import java.util.List;

import com.esprit.bookstore.entities.Reclamation;

public interface ReclamationService {
	
	public void ajouterReclamation(Reclamation reclamation);
	public void deleteReclamation(Reclamation reclamation);
	public void traiterReclamation(Reclamation reclamation);
	public List<Reclamation> getReclamations();
	
	
	
	



}
