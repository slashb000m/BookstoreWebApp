package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Livre;
import tn.esprit.spring.repository.LivreRepository;

@Service
public class LivreService {
	@Autowired
	private LivreRepository repository;

	public Livre AjouterLivre(Livre l) {
		return repository.save(l);
	}

	public List<Livre> AjouterLivres(List<Livre> l) {
		return repository.saveAll(l);

	}

	public Livre chercherLivreParI(int id) {
		return repository.findById(id).orElse(null);

	}

	public Livre chercherLivreParNom(String titre) {
		return repository.findByTitre(titre);

	}

	public List<Livre> afficherLiv() {
		return repository.findAll();

	}

	public String supprimerLivre(int id) {
		repository.deleteById(id);
		return "livre supprimée";

	}

	public Livre modifierLivre(Livre l) {
		Livre oldbook = repository.findById(l.getId_livre()).orElse(null);
		oldbook.setTitre(l.getTitre());
		oldbook.setAuteur(l.getAuteur());
		oldbook.setDescription(l.getDescription());
		return repository.save(oldbook);
	}
}
