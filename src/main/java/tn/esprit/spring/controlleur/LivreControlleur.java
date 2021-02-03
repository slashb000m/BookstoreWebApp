package tn.esprit.spring.controlleur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Livre;
import tn.esprit.spring.service.LivreService;

@RestController
@RequestMapping("/test1")
public class LivreControlleur {
	@Autowired
	private LivreService service;

	@GetMapping("/sayhallo")
	public String talk() {
		return "hallo alia ";
	}

	@GetMapping("/afficherLivres")
	public List<Livre> afficherLivres() {
		return service.afficherLiv();
	}

	@GetMapping("/chercherLivreParId/{id}")
	public Livre chercherLivreParId(@PathVariable int id) {
		return service.chercherLivreParI(id);
	}

	@DeleteMapping("/supprimerLivre/{id}")
	public String supprimerLivre(@PathVariable int id) {
		return service.supprimerLivre(id);

	}

	@PostMapping("/AjouterLivre")
	public Livre AjouterLivre(@RequestBody Livre l) {
		return service.AjouterLivre(l);
	}

	@PostMapping("/AjouterLivres")
	public List<Livre> AjouterLivres(@RequestBody List<Livre> l) {
		return service.AjouterLivres(l);
	}

	@PutMapping("/modifierLivre")
	public Livre modifierLivre( @RequestBody Livre l) {
		return service.modifierLivre(l);
	}

}
