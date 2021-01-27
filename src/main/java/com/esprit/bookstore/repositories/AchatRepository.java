package com.esprit.bookstore.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.esprit.bookstore.entities.Achat;
import java.sql.Date;

public interface AchatRepository  extends JpaRepository<Achat, Integer> {

	@Modifying
	@Transactional
	@Query(value="INSERT INTO  achat (id_achat, date_achat, prix_dachat, id_livre_achat, id_user_achat) VALUES (:idachat,:dAchat,:prixLivre,:idLivre,:idUser)",nativeQuery=true)
	public void ajouterAchat 
	(@Param("idLivre") int livreId,@Param("idUser") int userId,@Param("idachat") int idAchat,@Param("prixLivre") float prix,@Param("dAchat") Date dachat);
	

//java.sql.date.valuof.localdate.now;
}
