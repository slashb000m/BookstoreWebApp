package com.esprit.bookstore.entities;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.esprit.bookstore.entities.User;

public class MyUserDetails implements UserDetails {
	private User user;
    private List<GrantedAuthority> authorities;
	public MyUserDetails(User user) {
		//parcourir l'arrayList avec stream 
		  Arrays.stream(user.getRole().split(","))
          .map(SimpleGrantedAuthority::new)
          .collect(Collectors.toList());
	}
	
	public MyUserDetails() {
	
	}


	
	
	  @Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		  return authorities;
	}

	@Override
	public String getPassword() {
		 return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	



}
