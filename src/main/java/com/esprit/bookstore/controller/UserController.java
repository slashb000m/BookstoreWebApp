package com.esprit.bookstore.controller;

import java.util.List;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import com.esprit.DTO.SignUpRequestDTO;
import com.esprit.bookstore.entities.User;
//import com.esprit.bookstore.services.UserService;
import com.esprit.bookstore.services.UserService;

@Controller
@RestController
public class UserController {
	 @Autowired
	 UserService userService;
	
	 @GetMapping("/admin/users")
	    public ResponseEntity<List<User>> getAllUsers() {
	        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
	    }
	  @GetMapping("/user/{id}")
	    public ResponseEntity<User> getUserById(@PathVariable int id) {
	        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
	    }
	  @PostMapping("/user/add")
	    public ResponseEntity<User> addUser(@RequestBody User user, BindingResult result) throws Exception {
	        if (result.hasErrors())
	            System.err.println(result.getAllErrors());
	        return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
	    }
	   @PostMapping("/admin/add")
	    public ResponseEntity<User> addAdmin(@RequestBody User user, BindingResult result) throws Exception {
	        if (result.hasErrors())
	            System.err.println(result.getAllErrors());
	        return new ResponseEntity<>(userService.addAdmin(user), HttpStatus.CREATED);
	    }
//		@Autowired
//		UserServiceImpl userService;
//	
//		
//		@GetMapping("/api/admin/hello")
//		@PreAuthorize("hasRole('ADMIN')")
//		public String welcome() {
//			return "Welcome Admin";
//		}
//		@PostMapping("/api/auth/signup")
//		public @ResponseBody User  signUp(SignUpRequestDTO signUpDto)  {
//			User user = new User();
//			try{
//				signUpDto.setEmail("nimportequoi@gamil.Com");
//				signUpDto.setName("wael");
//				signUpDto.setPassword("blablablablabla");
//				signUpDto.setUsername("anyname");
//				
//				user = userService.saveUser(signUpDto);
//				
//				return user;
//
//			}catch(Exception ex){
//				ex.printStackTrace();
//			}
//			return null;
//		}
//		
//		@PostMapping("/addUser")
//		public void addUser(@RequestBody User user)
//		
//		{
//		
//			userService.ajouterUser(user);
//		}
//		
//		@PostMapping("/user/add")
//
//
//		public ResponseEntity<User> addUser(@RequestBody User user, BindingResult result) throws Exception {
//
//
//		if (result.hasErrors())
//
//
//		System.err.println(result.getAllErrors());
//
//
//		return new ResponseEntity<>(userService.addUser(user),HttpStatus.CREATED);
//}
////		@GetMapping("/api/profile")
////		ResponseEntity<User> getCurrentUserProfile(){
////			boolean   
////		}
//		
////		@GetMapping("/authentification")
////		public boolean Authentification(@RequestBody String email,@RequestBody String Password){
////			return userService.Authentification(email, Password);
////		}
////	
//				@PostMapping("/getUser")
////		@Produces(MediaType.APPLICATION_JSON)
////		@Consumes(MediaType.APPLICATION_JSON)
//		@RequestMapping(value = "/getuser/{idUser}", produces = "application/json")
//		public @ResponseBody String afficherDonnerPersonnelle(@PathVariable Integer idUser){
//			
//			String userData = userService.afficherDonnerPersonnelle(idUser);
//			return userData;
//			
//		}
}
