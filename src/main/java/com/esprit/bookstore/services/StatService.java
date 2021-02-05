package com.esprit.bookstore.services;

import java.util.List;

import com.esprit.bookstore.DAO.ChiffreAffaireMensuelI;
import com.esprit.bookstore.DAO.ChiffreDaffaireMensuel;
import com.esprit.bookstore.DAO.LivreVenduParCategorie;
import com.esprit.bookstore.DAO.LivreVenduParCategorieI;

public interface StatService {
	public List<ChiffreAffaireMensuelI> getCaService();
	public List<LivreVenduParCategorieI> getLivreVenduParCategorie();

}
