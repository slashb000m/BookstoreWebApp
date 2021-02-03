package com.esprit.bookstore.repositories;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.esprit.bookstore.entities.Livre;
import com.esprit.bookstore.entities.User;



public interface UserRepository extends JpaRepository<User, Integer>{

	@Modifying
	@Transactional
	@Query(value="INSERT INTO livre_user_souhait (livre_souhaite_id_livre,user_souhait_id_user) VALUES(:livreId,:userId)",nativeQuery=true)
	public void addsouhait
	(@Param("livreId") int livreId,@Param("userId") int userId);
	
	@Modifying
	@Transactional
	@Query(value="DELETE FROM livre_user_souhait WHERE livre_souhaite_id_livre = (:lId)",nativeQuery=true)
	public void DeletSouhait
	(@Param("lId") int lId);
	
	@Modifying
	@Transactional
	@Query(value="SELECT id_livre, auteur, categorie, date_insertion, nbr_pages, prix, titre, type FROM livre_user_souhait AS s "
			+ "JOIN livre AS l ON l.id_livre = s.livre_souhaite_id_livre  JOIN user AS u ON u.id_user = s.user_souhait_id_user "
   +"where s.user_souhait_id_user= (:uId)",nativeQuery=true)
	public List<Integer> listerSouhaits
	(@Param("uId") int uId);

	@Modifying
	@Transactional
	@Query(value="SELECT * from user u where genre_prefere =(:genre) or auteur_prefere = (:aut)  ",nativeQuery=true)
	public List<User> listerUsersPargenreAuteur
	(@Param("genre") String genre , @Param ("aut") String aut);

	
	@Modifying
	@Transactional
	@Query(value="SELECT user_souhait_id_user FROM  livre_user_souhait WHERE livre_souhaite_id_livre =(:lId) ",nativeQuery=true)
	public List<Integer> listerUsersParSouhait
	(@Param("lId") int lId);
//
//	@Modifying
//	@Transactional
//	@Query(value="UPDATE livre set prix = (:prix ) where id_livre = (:lId)",nativeQuery=true)
//	public void accorderreduction(@Param(":lId") int lId , @Param(":prix") float prix);




}
