package com.esprit.bookstore.services;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.esprit.bookstore.entities.Livre;
import com.esprit.bookstore.entities.User;
import com.esprit.bookstore.repositories.LivreRepository;
import com.esprit.bookstore.repositories.UserRepository;
@Service
public class UserServiceImpl  implements UserService{
	
	@Autowired
	UserRepository urepo;
    @Autowired
    LivreRepository livrepo;
	@Override
	public void ajouterSouhait(int id_livre, int id_user) {
		
		// urepo.findById(id_user).get().getLivreSouhaite().add(livrepo.findById(id_livre).get());
		 
		urepo.addsouhait(id_livre, id_user); 
		
	}
	@Override
	public void supprimerSouhait(int id_livre , int id_user) {
	//	urepo.findById(id_user).get().getLivreSouhaite().remove(livrepo.findById(id_livre).get());
		urepo.DeletSouhait(id_livre);
		
	}
	@Override
	public List<Livre> listerSouhait(int id_user) {
	List<Livre> listLivre = new ArrayList<>();
	List<Integer> s = urepo.listerSouhaits(id_user);
	for(int i=0; i< s.size() ; i++ )
	{
		
		listLivre.add(i, livrepo.findById(s.get(i)).get());
		
		
	}
	
	return listLivre;
	
	}
	@Override
	public float reductionAccord(int id_livre, int percentage) {
		
		float oldprice= (livrepo.findById(id_livre).get().getPrix());
		float newprice = oldprice -((oldprice*percentage)/100);
		livrepo.findById(id_livre).get().setPrix(newprice);
		livrepo.save(livrepo.findById(id_livre).get());
		return newprice;
			}
	@Override
	public List<User> utilisateursparSouhait(int id_livre) {
		List<User> listUsers = new ArrayList<>();
		List <Integer>l = (ArrayList<Integer>)urepo.listerUsersParSouhait(id_livre);
		
		for (int i=0 ; i< l.size(); i++)
		{ int id = l.get(i);
		listUsers.add( urepo.findById(id).get());
		}
		return listUsers;
	}
	@Override
	public List<User> utilisteurspargenreetauteur(int id_livre) {
		Livre l = livrepo.findById(id_livre).get();
		
		return urepo.listerUsersPargenreAuteur(l.getCategorie(), l.getAuteur());
	}

	public InputStreamResource DownloadBook (HttpServletResponse response , int idLivre) throws IOException {
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment; filename=\"test.pdf\"");
		InputStreamResource resource = new InputStreamResource(new FileInputStream(livrepo.findById(idLivre).get().getUrl()));
		return resource;
	}
	
	
//	 void telecharger_pdf_gratuit(int idLivre) {
//	        FileChooser fc = new FileChooser();
//	        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PDF files","*.pdf"));
//	        File selectedFile =fc.showSaveDialog(null);
//	        
//	try (BufferedInputStream in = new BufferedInputStream(new URL("https://www.win.tue.nl/~marko/latex/exercises/day2/snowwhite2.pdf").openStream());
//	  FileOutputStream fileOutputStream = new FileOutputStream(selectedFile)) {
//	    byte dataBuffer[] = new byte[1024];
//	    int bytesRead;
//	    while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
//	        fileOutputStream.write(dataBuffer, 0, bytesRead);
//	    }
//	} catch (IOException e) {
//	    e.getMessage();
//	    // handle exception
//	}
	        
	    
}
