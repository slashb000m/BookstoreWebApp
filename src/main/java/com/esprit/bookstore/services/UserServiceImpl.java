package com.esprit.bookstore.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.rest.webmvc.ResourceNotFoundException;
//import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.esprit.bookstore.entities.Statut;
import com.esprit.bookstore.entities.User;
import com.esprit.bookstore.repositories.UserRepository;
import com.esprit.bookstore.security.SecurityConfig;
import com.esprit.bookstore.entities.MyUserDetails;
@Service
public class UserServiceImpl implements UserService,UserDetailsService {
	@Autowired
	UserRepository userRepository;

    @Autowired
    SecurityConfig securityConfig;
    
    
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		 Optional<User> user= userRepository.getUserByUsername(username);
		 user.orElseThrow(()-> new UsernameNotFoundException("No user with the username "+username));

	        return new MyUserDetails(user.get());
}

	@Override
	public User getUserById(int id) {
		  return userRepository.findById(id).orElse(null);
//				  orElseThrow(() -> new ResourceNotFoundException("No " +
//	                "user found with the ID "+ id));
	}

	@Override
	public java.util.List<User> getAllUsers() {
        return userRepository.findAll();
	}

	@Override
	public User addUser(User user) throws Exception {
		   if (userRepository.getUserByUsername(user.getUsername()).isPresent()) throw new Exception("This " +
	                "username " +
	                "already exist");
	        user.setPassword(securityConfig.passwordEncoder().encode(user.getPassword()));
	        user.setRole("ROLE_USER");
		return userRepository.save(user);
	}

	@Override
	public User addAdmin(User user)throws Exception {
		  if (userRepository.getUserByUsername(user.getUsername()).isPresent()) throw new Exception("This  admin " +
	                "already exist");
	        user.setPassword(securityConfig.passwordEncoder().encode(user.getPassword()));
	        user.setRole("ROLE_ADMIN");		
	        return userRepository.save(user);
	}

//	@Override
//	public User deleteUser(int userId) {
//		
//	               
//	}

	@Override
	public User updateUserName(int userId, User user) {
		User u = getUserById(userId);
        u.setUsername(user.getUsername());
        return userRepository.save(u);
	}

	
	
	
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
//	@Override
//	public String afficherDonnerPersonnelle(int id) {
//		
//		User e = userRepository.findById(id).get();
//	return e.toString()	;	
//	}
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
