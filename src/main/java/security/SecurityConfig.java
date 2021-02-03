package security;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.esprit.bookstore.entities.User;
import com.esprit.bookstore.repositories.UserRepository;
import com.esprit.bookstore.services.UserServiceImpl;

import jwt.JwtusernamePasswordAuthenticationFilter;
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig /* extends WebSecurityConfigurerAdapter*/  {
//private final PasswordEncoder passwordEncoder;
//@Autowired
//private final UserServiceImpl applicationUserService;
//
//public SecurityConfig(PasswordEncoder passwordEncoder, UserServiceImpl applicationUserService) {
//	
//	this.passwordEncoder = passwordEncoder;
//	this.applicationUserService = applicationUserService;
//}
////configuring http requests to secure users from csrf attacks (accepts requests only from browser)
//// session is stateless because i'm authenticated with Jwt(token)
//// for authorized requests i'm going from the most restricted to the least restricted 
////every request need authentication process
//@Override
//protected void configure(HttpSecurity http) throws Exception {
//	// TODO Auto-generated method stub
//http.csrf().disable()
//      .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//       .and()
//       . authorizeRequests()
//       .antMatchers("/api/admin/**").hasRole("ADMIN")
//        .antMatchers("/api/client/**").hasAnyRole("CLIENT","ADMIN")
//        .antMatchers("/api/auth/signup").permitAll()
//        .and().httpBasic();
////         .authenticated();
////        http.addFilterBefore(new JwtusernamePasswordAuthenticationFilter(authenticationManager()), UsernamePasswordAuthenticationFilter.class);
////         http.addFilterAfter(new JwtTokenVerifier(), JwtusernamePasswordAuthenticationFilter.class);
//}
//@Override
//protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//	auth.authenticationProvider(daoAuthenticationProvider());
//}
//@Bean DaoAuthenticationProvider daoAuthenticationProvider(){
//	DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//	provider.setPasswordEncoder(passwordEncoder);
//	provider.setUserDetailsService(applicationUserService);
//	return provider;
//}
//@Autowired
//UserRepository userRepository;
//
//
//
//
//@PostConstruct
//public void init(){
//if (userRepository.findAll().size()==0){
//User user = new User();
//    user.setUsername("admin");
//   user.setPassword(passwordEncoder.encode("admin"));
//   user.setRole("ROLE_ADMIN,ROLE_USER");
//   userRepository.save(user);
//   }
//}


}




