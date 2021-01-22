package com.esprit.bookstore.repositories;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.bookstore.entities.Reclamation;

@Repository
public interface ReclamationRepository extends JpaRepository<Reclamation, Integer> {
	
	@Modifying
	@Transactional
	@Query(value="INSERT INTO reclamation (titre,texte,date_creation,user_reclamation_id) VALUES(:titre,:texte,:dateCreation,:userId)",nativeQuery=true)
	public void addReclamation
	(@Param("titre") String titre,@Param("texte") String texte,@Param("dateCreation") Date dateCreation,@Param("userId") int userId);
	


	
	
	
	

}
