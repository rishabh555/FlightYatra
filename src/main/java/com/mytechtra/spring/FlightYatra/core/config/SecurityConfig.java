package com.mytechtra.spring.FlightYatra.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.savedrequest.NullRequestCache;
import org.springframework.web.server.session.HeaderWebSessionIdResolver;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	 
	//In Memory
	/*@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) 
	  throws Exception {
	    auth.inMemoryAuthentication()
	      .withUser("admin").password(encoder().encode("admin123")).authorities("ROLE_USER")
	      .and()
	      .withUser("jrajuv").password(encoder().encode("admin123")).authorities("ROLE_ADMIN")

	      ;
	}*/
	
	@Autowired
	private UserDetailsService flightUsersService;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) 
	  throws Exception {
	    auth.userDetailsService(flightUsersService);
		
		
	}
	
	//This for password encoding
	@Bean
	public PasswordEncoder  encoder() {
	    return new BCryptPasswordEncoder();
	}
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception { 
		http
	   .csrf()
	   .disable()
	   .authorizeRequests()
	   //this to skip authentication for swagger
	   .antMatchers("/swagger-ui.html" , "/webjars/**" , "/swagger-resources/**" , "/v2/api-docs/**")
	   .anonymous()
	   //.antMatchers("/FYatra/flights**").access("hasRole('ROLE_ADMIN')")
	   .antMatchers("/**")
	   .authenticated()
       .and()
       
	    .httpBasic();
	    
	}
}
