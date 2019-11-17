package com.mytechtra.spring.FlightYatra.security;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FlightUsersDAO {
	
	@Autowired
	private EntityManager manager;
	
	public FlightUser findByName(String userName) {
		  return (FlightUser) manager.createNamedQuery("findByName").setParameter(1,userName).getSingleResult();
		}

}
