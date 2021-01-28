package com.esprit.bookstore.repositories;

import java.util.List;

import javax.transaction.Transactional;
import com.esprit.bookstore.entities.Statut;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.bookstore.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	
	@Query(value = "select email from user where email = :email and password= :password",nativeQuery=true)
	public	String isAuthenticated(@Param("email") String email,@Param("password") String password);
	@Query(value = "select id_user from user where email = :email and password= :password", nativeQuery=true)
	public	int recevoireEmployeeParId(@Param("email") String email,@Param("password") String password);
//  //  @Modifying    
////	@Query("update User u set u.nom = :nom , u.prenom , u.email= :email , u.password= :password ,"
////			+ " u.statut = :statut , u.auteurPrefere = :auteurPrefere , u.genrePrefere = :genrePrefere where u.idUser = :idUser")
////    public void miseAjour(@Param("nom")String nom,@Param("prenom")String prenom,@Param("email") String email,@Param("password")String password,
////    		@Param("statut")Statut statut,@Param("auteurPrefere")String auteurPrefere,@Param("genrePrefere")String genrePrefere,@Param("idUser")int idUser);
   @Modifying
   @Transactional
    @Query(value="INSERT INTO user (auteur_prefere,date_inscription,email,genre_prefere,nom,password,prenom,statut,id_user) VALUES(:auteur_prefere,:date_inscription,:email,:genre_prefere,:nom,:password,:prenom,:statut,:id_user)",nativeQuery=true)
	public void addUser
	(@Param("auteur_prefere")String auteur_prefere,@Param("date_inscription")java.sql.Date date,@Param("email") String email,
			@Param("genre_prefere")String genre_prefere,@Param("nom")String nom,@Param("password")String password,@Param("prenom")String prenom,
			@Param("statut")String satut,@Param("id_user") int id_user);
   
}
