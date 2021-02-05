package com.esprit.bookstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.bookstore.DAO.AccorderReductionDAO;
import com.esprit.bookstore.repositories.ReductionRepository;


@Service
public class ReductionServiceImpl implements ReductionService{
	
	@Autowired
	ReductionRepository reductionRepository;

	@Override
	public void accorderReduction(AccorderReductionDAO reductionData) {
		int idLivre = reductionData.getIdLivre();
		int pourcentageReduction = reductionData.getPourcentageReduction();
		reductionRepository.accorderReduction(pourcentageReduction,idLivre);
		
		
	}
	

}
