package com.esprit.bookstore.controller;



import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.weaver.patterns.IVerificationRequired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import com.esprit.bookstore.entities.Livre;
import com.esprit.bookstore.entities.User;
import com.esprit.bookstore.repositories.LivreRepository;
import com.esprit.bookstore.repositories.UserRepository;
import com.esprit.bookstore.services.EmailService;
import com.esprit.bookstore.services.UserService;
import com.esprit.bookstore.services.UserServiceImpl;
import com.esprit.bookstore.services.achatService;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;





@RestController
public class UserController {
	@Autowired
	HttpServletResponse response;
	@Autowired
	UserService u;
	@Autowired
	UserRepository ur;
	@Autowired 
	LivreRepository lr;
	@Autowired
	achatService as;
@Autowired 
EmailService es;


	
	@RequestMapping(value ="/addSouhait/{idLivre}/{idUser}" , produces = "application/json")
	public @ResponseBody String addBookToWishlist(@PathVariable("idUser") Integer idUser, @PathVariable("idLivre") Integer idLivre)
	{
		u.ajouterSouhait(idLivre,idUser);
		
		return "livre ajoutée à la liste des souhaits";
	}
	
	@DeleteMapping("/deleteSouhait")
	public String deleteBookfromwishList()
	{
		u.supprimerSouhait(1,1);
		return " book deleted from wishlist";
		 
	}
	
	@RequestMapping(value = "/getSouhait/{idUser}", produces = "application/json")
	public @ResponseBody List<Livre> afficherDonnerPersonnelle(@PathVariable("idUser") Integer idUser){
   
		List<Livre> l = u.listerSouhait(idUser);
		
		return l;
		
 
}
	
	@RequestMapping(value = "/ajouterAchat/{idUser}/{idLivre}",produces = "application/json")
	public String ajouterAchat(@PathVariable("idUser") Integer idUser, @PathVariable("idLivre") Integer idLivre) throws IOException
	{
		as.acheterLivre(idUser, idLivre);
		if (lr.findById(idLivre).get().getPrix()==0)
		{
			//u.DownloadBook(response, idLivre);
			
		}
		
	
	return "livre acheté";
	}
//	
	@RequestMapping(value = "/AR/{percent}/{idLivre}",produces = "application/json")
	public String ajouterreduc(@PathVariable("percent") Integer percent, @PathVariable("idLivre") Integer idLivre)
	{
		
	float nprice = u.reductionAccord(idLivre, percent)	;
	List<User> anotifPargenreAuteur = u.utilisteurspargenreetauteur(idLivre);
	List<User> anotifierparsouhait = u.utilisateursparSouhait(idLivre);
	String nom_du_livre= lr.findById(idLivre).get().getTitre();
	for (User user : anotifierparsouhait) {
		es.sendSimpleMessage(user.getEmail(), "reduction au livre qui fait partie de votre souhait", " le livre "+ nom_du_livre+"  fait partie de votre wishlist et est maintenant sous reduction son nouveau prix est : "+ nprice);	
	}
	 for (User user : anotifPargenreAuteur) {
		 es.sendSimpleMessage(user.getEmail(), "reduction d'un livre de votre genre et auteur preférés ", " le livre "+ nom_du_livre+"  fait partie de votre wishlist et est maintenant sous reduction son nouveau prix est : "+ nprice);
		
	}
	
	
	return "reduction acordée , verifiez votre mail";
	}
	@RequestMapping(value = "downloadTestFile", method = RequestMethod.GET)
	public InputStreamResource FileSystemResource (HttpServletResponse response) throws IOException {
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment; filename=\"test.pdf\"");
		InputStreamResource resource = new InputStreamResource(new BufferedInputStream(new URL("https://www.win.tue.nl/~marko/latex/exercises/day2/snowwhite2.pdf").openStream()));
		 FileOutputStream fileOutputStream = new FileOutputStream(new File("C:\\Users\\mhayari\\Desktop\\books") );
//			    byte dataBuffer[] = new byte[1024];
//			    int bytesRead;
//			    while ((bytesRead = re.read(dataBuffer, 0, 1024)) != -1) {
//			        fileOutputStream.write(dataBuffer, 0, bytesRead);
//			    }
		return resource;
	}	
}

