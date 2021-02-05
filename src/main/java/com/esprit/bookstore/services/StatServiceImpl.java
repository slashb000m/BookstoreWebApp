package com.esprit.bookstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.bookstore.DAO.ChiffreAffaireMensuelI;
import com.esprit.bookstore.DAO.ChiffreDaffaireMensuel;
import com.esprit.bookstore.DAO.LivreVenduParCategorie;
import com.esprit.bookstore.DAO.LivreVenduParCategorieI;
import com.esprit.bookstore.repositories.StatRepository;

@Service
public class StatServiceImpl implements StatService {

	@Autowired
	StatRepository statRepository;
	
	@Override
	public List<ChiffreAffaireMensuelI> getCaService() {
		return statRepository.ChiffreDaffaireMensuel();
		
	}

	@Override
	public List<LivreVenduParCategorieI> getLivreVenduParCategorie() {
	return statRepository.proportionLivreParCategorie();
	}

}
