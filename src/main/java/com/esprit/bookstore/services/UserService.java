package com.esprit.bookstore.services;

import java.util.List;


import com.esprit.bookstore.entities.Livre;


public interface UserService {
	public void ajouterSouhait(int id_livre , int id_user);
    public void supprimerSouhait(int id_livre , int id_user);
    public List<Livre> listerSouhait(int id_user);
    
  public float reductionAccord(int id_livre , int percentage);
}
