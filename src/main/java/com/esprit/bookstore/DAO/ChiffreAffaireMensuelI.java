package com.esprit.bookstore.DAO;

import java.util.Date;

public interface ChiffreAffaireMensuelI {
	public float getSomme_mois_cumulé();
	public void setSomme_mois_cumulé(float somme_mois_cumulé);
	Date getDate_achat();
	public void setDate_achat(Date date_achat);

}
