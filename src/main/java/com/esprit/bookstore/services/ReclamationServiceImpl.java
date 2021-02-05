package com.esprit.bookstore.services;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.bookstore.entities.Reclamation;
import com.esprit.bookstore.mailing.JavaMailUtil;
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
	    String mailContainer="Monsieur/madame"+
	    		"votre reclamation a été consulté par l'administrateur du site,malheuresement, il a jugé qu'elle n'etait pas assez "
	    		+ "pertinente pour etre traité, veuillez contacter le support pour plus d'information.";
	    	JavaMailUtil.sendMail(reclamation.getUserReclamation().getEmail(),"Retour sur reclamation", mailContainer);
 
		
		
	}

	@Override
	public void traiterReclamation(Reclamation reclamation) {
		int id = reclamation.getId();		
		reclamationRepository.deleteById(id);
	    String mailContainer="Monsieur/madame"+
	    		"votre reclamation a été consulté par l'administrateur du site, elle est en cours de traitement, "
	    		+ "nous vous recontacterons si besoin, veuillez contacter le support pour plus d'information.";
	    	JavaMailUtil.sendMail(reclamation.getUserReclamation().getEmail(),"Retour sur reclamation", mailContainer);
		
	}

	@Override
	public List<Reclamation> getReclamations() {
		return reclamationRepository.findAll();
	}
	
	
	   



}
