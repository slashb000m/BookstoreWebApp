package com.esprit.bookstore.DAO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


public class AccorderReductionDAO {
	@JsonProperty("idLivre")
	int idLivre;
	@JsonProperty("pourcentageReduction")
	int pourcentageReduction;
	
	
	public int getIdLivre() {
		return idLivre;
	}
	public void setIdLivre(int idLivre) {
		this.idLivre = idLivre;
	}

	public int getPourcentageReduction() {
		return pourcentageReduction;
	}
	public void setPourcentageReduction(int pourcentageReduction) {
		this.pourcentageReduction = pourcentageReduction;
	} 
	
	

}
