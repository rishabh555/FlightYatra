package com.mytechtra.spring.FlightYatra.security;

import java.util.Collection;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.UserDetailsManagerConfigurer.UserDetailsBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class FlightUsersService implements UserDetailsService {

	@Autowired
	FlightUsersDAO FlightUsersDAO;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		try
		{
			FlightUser user = FlightUsersDAO.findByName(userName);
			user.setPassword(encoder.encode(user.getPassword()));
			return user;
		} catch (NoResultException ex) {
			throw new UsernameNotFoundException("Not found");
		}
		
	}
	
	

}
