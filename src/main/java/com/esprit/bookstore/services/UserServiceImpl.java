package com.esprit.bookstore.services;


import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.rest.webmvc.ResourceNotFoundException;
//import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.authentication.AuthenticationManager;

import com.esprit.bookstore.entities.Statut;
import com.esprit.bookstore.entities.User;
import com.esprit.bookstore.repositories.UserRepository;
import com.esprit.bookstore.security.SecurityConfig;

import com.esprit.bookstore.entities.MyUserDetails;
@Service
public class UserServiceImpl implements UserService,UserDetailsService{
//@Override
//	public ResponseEntity login(MyUserDetails loginRequest) {
//	  Authentication authenticate = authenticationManager.authenticate(
//              new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
//              loginRequest.getPassword()));
//      SecurityContextHolder
//              .getContext()
//              .setAuthentication(authenticate);
//      System.err.println("login request: "+loginRequest);
//      System.err.println("authenticate: "+authenticate);
//      return new ResponseEntity(loginRequest.getUsername(), HttpStatus.OK);
//	}



	@Autowired
	UserRepository userRepository;

    @Autowired
    SecurityConfig securityConfig;
    
    
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		 Optional<User> user= userRepository.getUserByUsername(username);
		 user.orElseThrow(()-> new UsernameNotFoundException("No user with the username "+username));

	        return new MyUserDetails(user.get());
}

	@Override
	public User getUserById(int id) {
		  return userRepository.findById(id).orElse(null);
				
	}

	@Override
	public java.util.List<User> getAllUsers() {
        return userRepository.findAll();
	}

	@Override
	public User addUser(User user) throws Exception {
		long millis=System.currentTimeMillis();
		   if (userRepository.getUserByUsername(user.getUsername()).isPresent()) throw new Exception("This " +
	                "username " +
	                "already exist");
		   user.setDateInscription(new java.sql.Date(millis));
	        user.setPassword(securityConfig.passwordEncoder().encode(user.getPassword()));
	        user.setRole("ROLE_USER");
		return userRepository.save(user);
	}

	@Override
	public User addAdmin(User user)throws Exception {
		long millis=System.currentTimeMillis();
		  if (userRepository.getUserByUsername(user.getUsername()).isPresent()) throw new Exception("This  admin " +
	                "already exist");
	        user.setPassword(securityConfig.passwordEncoder().encode(user.getPassword()));
	        user.setRole("ROLE_ADMIN");	
	        user.setDateInscription(new java.sql.Date(millis));
	        return userRepository.save(user);
	}

//	@Override
//	public User deleteUser(int userId) {
//		
//	               
//	}

	@Override
	public User updateProfile(int id, User user) {
		User currentUser = userRepository.findById(id).get();
		currentUser.setUsername(user.getUsername());
        currentUser.setAuteurPrefere(user.getAuteurPrefere());
        currentUser.setEmail(user.getEmail());
        currentUser.setGenrePrefere(user.getGenrePrefere());
        currentUser.setStatut(user.getStatut());
        return userRepository.save(currentUser);
	}
	
	@Override
	public User afficherDonnerPersonnelle(String userName) {
		
		User user = userRepository.getUserByUsername(userName).get();
			
	return 	user;	
	}
	@Override
	public boolean signIn(String username,String password) {
		boolean exit = false;
		User user = userRepository.getUserByUsername(username).get();
		
//	User user = userRepository.getUserByUsername(userName).orElse(null);
//			//orElseThrow(()-> new UsernameNotFoundException("No user with the username "+userName));
		System.out.println(securityConfig.passwordEncoder().encode(user.getPassword()));
		System.out.println(securityConfig.passwordEncoder().hashCode());
	if(user.getUsername().equals(username) &(securityConfig.passwordEncoder().matches(password, user.getPassword()))){
		
		exit = true;
	}else{
		exit= false;
	}
	return exit;
	}
//		 if (!(userRepository.getUserByUsername(userName).isPresent())) {
//			return null;
//		 }
//		 else{
//	user	 = userRepository.getUserByUsername(userName).get();
//		 }
//	if (user.getPassword().equals(securityConfig.passwordEncoder().encode(password))){
//		return user;
//	}
//	else return user; 
	
	 
	
	
// modifiying how the value of role should be recieved to do the authorization process
	
	
//	String ROLE_PREFIX = "ROLE_";
//	
//	
//	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//		User user = userRepository.findbyUsername(username);
//		ArrayList<GrantedAuthority> listOfAuthorities = new ArrayList<GrantedAuthority>();
//		// exigence of role 
//		listOfAuthorities.add(new SimpleGrantedAuthority(user.getRole()));
//		
//		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), listOfAuthorities);
//	}
//
//	public User saveUser(SignUpRequestDTO user) {
//		user.setPassword(new BCryptPasswordEncoder(10).encode(user.getPassword()));
////		UserRole = ROLE_CLIENT
//		User userToSave = new User(user.getName(),user.getUsername(), user.getEmail(), user.getPassword(), ROLE_PREFIX + "CLIENT"); 
//		return userRepository.save(userToSave);}
//	
//	public User getUserByUsername(String username) {
//		return userRepository.findbyUsername(username);
//	}
//	////////////////////////////////////////////////////////////////
//
//	@Override
//	public void ajouterUser(User user) {
////	 String nom = user.getNom();
////	 String prenom = user.getPrenom();
////	 String password = user.getPassword();
////	 String email = user.getEmail();
////	 String statut = user.getStatut().toString();
////	 String autpref = user.getAuteurPrefere();
////	 String genpref = user.getGenrePrefere();
//	 
////		String nom = "maa";
////		String prenom = "maa"; 
//	 long millis=System.currentTimeMillis();
//	 java.sql.Date date=new java.sql.Date(millis);
//
//user.setDateInscription(date);
//String oldRole = user.getRole();
//user.setRole(ROLE_PREFIX+oldRole);
//user.setPassword(new BCryptPasswordEncoder(10).encode(user.getPassword()));
//userRepository.save(user);	
//	}
//	
//
//
//
////	@Override
////	public boolean Authentification(String email, String Password) {
////		if( userRepository.isAuthenticated(email, Password).equals(null)) {return false ; }
////		 else{
////		 CurrentUser = getUser(userRepository.recevoireEmployeeParId(email, Password));
////			 return true ;
////		 
////		 }
////	}
////
//	
////
//	@Override
//	public User getUser(int idUser) {
//		
//		User user =	userRepository.findById(idUser).get();
//		return user;
//	}
//	
//	public User addUser(User user) throws Exception {
//
//
//			if ((userRepository.findbyUsername(user.getUsername()) !=  null))
//			throw new Exception("This" +	"username " +"already exist");
//			user.setPassword(new BCryptPasswordEncoder(10).encode(user.getPassword()));
////if (userRepository.getUserByUserName(user.getUserName()).isPresent())
//			
//			user.setRole("ROLE_USER");
//			return userRepository.save(user);
//			}
	
	

}
