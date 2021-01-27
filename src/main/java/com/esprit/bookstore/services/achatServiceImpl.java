package com.esprit.bookstore.services;


import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.bookstore.entities.Achat;
import com.esprit.bookstore.entities.Livre;
import com.esprit.bookstore.entities.User;
import com.esprit.bookstore.repositories.AchatRepository;
import com.esprit.bookstore.repositories.LivreRepository;
import com.esprit.bookstore.repositories.UserRepository;

@Service
public class achatServiceImpl implements achatService{

	@Autowired
	UserRepository urepo;
    @Autowired
    LivreRepository livrepo;
    
    @Autowired
    AchatRepository arepo;
	
	@Override
	public void acheterLivre(int idUser, int idLivre) {
		User u = urepo.findById(idUser).get(); 
		Livre l = livrepo.findById(idLivre).get();
		
		java.sql.Date date=Date.valueOf(LocalDate.now());
			
		Achat a = new Achat();
		
		//(l.getIdLivre(), u.getIdUser(),1, l.getPrix(), date);
		a.setLivreAchat(l);
		a.setDate(date);
		a.setPrixAchat(l.getPrix());
		a.setUserAchat(u);
		
		arepo.save(a);
	}

}
