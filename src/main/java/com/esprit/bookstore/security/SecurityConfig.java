package com.esprit.bookstore.security;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import com.esprit.bookstore.repositories.UserRepository;
import com.esprit.bookstore.services.UserServiceImpl;
import com.esprit.bookstore.entities.User;
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	 @Autowired
	    UserRepository userRepository;
@Autowired
private PasswordEncoder passwordEncoder;


@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {

	auth.userDetailsService(getUserDetailsService());
}

@Override
protected void configure(HttpSecurity http) throws Exception {
	http.cors().and().csrf().disable().authorizeRequests()
    .antMatchers("/user/add").permitAll()
    .antMatchers("/admin/add").hasRole("ADMIN")
    .antMatchers("/user/updateUser/{id}").permitAll()
    .antMatchers("/user/signIn").permitAll()
    .antMatchers("/user/{id}/delete").hasRole("ADMIN")
    .and().httpBasic();
}

@Bean
public UserDetailsService getUserDetailsService() {
    return new UserServiceImpl();
}
@Bean
public PasswordEncoder passwordEncoder() {
	
    return new BCryptPasswordEncoder(10);
}

@PostConstruct
public void init(){
    if (userRepository.findAll().size()==0){
        User user = new User();
        user.setUsername("admin");
        user.setPassword(passwordEncoder.encode("admin"));
        user.setRole("ROLE_ADMIN,ROLE_USER");
        userRepository.save(user);
    }
}


}
