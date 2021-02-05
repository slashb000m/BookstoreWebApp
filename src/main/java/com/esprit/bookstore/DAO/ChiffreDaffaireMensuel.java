package com.esprit.bookstore.DAO;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;



public class ChiffreDaffaireMensuel implements ChiffreAffaireMensuelI{
	float somme_mois_cumulé;
	Date date_achat;
	public float getSomme_mois_cumulé() {
		return somme_mois_cumulé;
	}
	public void setSomme_mois_cumulé(float somme_mois_cumulé) {
		this.somme_mois_cumulé = somme_mois_cumulé;
	}
	public Date getDate_achat() {
		return date_achat;
	}
	public void setDate_achat(Date date_achat) {
		this.date_achat = date_achat;
	}
	
	
    
}
