package com.esprit.bookstore.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.bookstore.entities.Livre;
import com.esprit.bookstore.entities.Reclamation;


@Repository
public interface ReductionRepository extends CrudRepository<Reclamation, Integer>{
	
	@Modifying
	@Transactional
	@Query(value="UPDATE livre set prix = :pourcentageReduction  where id_livre = :idLivre ",nativeQuery=true)
	public void accorderReduction
	(@Param("pourcentageReduction") int pourcentageReduction ,@Param("idLivre") int idLivre);

}
