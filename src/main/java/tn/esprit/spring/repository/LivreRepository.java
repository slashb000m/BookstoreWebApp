package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.entities.Livre;

public interface LivreRepository extends JpaRepository<Livre, Integer> {
	Livre findByTitre(String titre);

}