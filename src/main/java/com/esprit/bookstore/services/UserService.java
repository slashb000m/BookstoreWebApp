package com.esprit.bookstore.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.InputStreamResource;

import com.esprit.bookstore.entities.Livre;
import com.esprit.bookstore.entities.User;


public interface UserService {
	public void ajouterSouhait(int id_livre , int id_user);
    public void supprimerSouhait(int id_livre , int id_user);
    public List<Livre> listerSouhait(int id_user);
  public float reductionAccord(int id_livre , int percentage);
  public List<User> utilisateursparSouhait(int id_livre);
  public List<User> utilisteurspargenreetauteur(int id_livre);
  public InputStreamResource DownloadBook (HttpServletResponse response , int idLivre) throws IOException;
}
