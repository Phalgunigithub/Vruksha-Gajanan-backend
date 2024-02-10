 package com.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.UserDao;
import com.app.entities.User;

@Service
public class CustomerUserDetailsService implements UserDetailsService {

	
	@Autowired
	private UserDao udao;
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User u1=this.udao.findByemail(email).orElseThrow(()->new ResourceNotFoundException("user not found"));
		return u1;
	}

}
