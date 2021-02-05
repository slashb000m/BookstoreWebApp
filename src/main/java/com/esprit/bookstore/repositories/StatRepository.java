package com.esprit.bookstore.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.bookstore.DAO.ChiffreAffaireMensuelI;

import com.esprit.bookstore.DAO.LivreVenduParCategorieI;
import com.esprit.bookstore.entities.Reclamation;

@Repository
public interface StatRepository extends CrudRepository<Reclamation, Integer> {
	
	@Query(value="select sum(prix_dachat) as somme_mois_cumulé, date_achat from achat GROUP BY month(date_achat)",nativeQuery=true)
	public List<ChiffreAffaireMensuelI> ChiffreDaffaireMensuel();
	
	@Query(value="select count(*) as \"livres_vendu\", livre.categorie from achat join livre on livre.id_livre = achat.id_livre_achat group by description",nativeQuery=true)
	public List<LivreVenduParCategorieI> proportionLivreParCategorie();

}
