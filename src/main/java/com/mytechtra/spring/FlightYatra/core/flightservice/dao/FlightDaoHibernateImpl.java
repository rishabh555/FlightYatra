package com.mytechtra.spring.FlightYatra.core.flightservice.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jayway.jsonpath.Criteria;
import com.mysql.cj.Query;
import com.mytechtra.spring.FlightYatra.model.Flight;
import com.mytechtra.spring.FlightYatra.model.Flight.AirLine;

@Component
public class FlightDaoHibernateImpl implements  FlightDao{
	
	@Autowired
	private EntityManager manager;
	
	
	@Override
	public Flight getFlight(Long id) {
		return manager.find(Flight.class, id );
		
	}

	@Override
	public void save(Flight flight) {
		manager.persist(flight);
		
	}

	@Override
	public void update(Flight flight) {
		manager.merge(flight);
		
	}

	@Override
	public boolean delete(Flight flight) {
		manager.remove(flight);
		return true;
	}

	@Override
	public List<Flight> listFlights() {
	  return manager
			.createNamedQuery("getAllFlights")
			.getResultList();
	}

	//HQL way
	/*@Override
	public List<Flight> listFlightsByAirline(AirLine airline) {
		  return manager
					.createNamedQuery("getFlightsByAirline")
					.setParameter(1, airline)
					.getResultList();
	}*/
	
	//Criterai way
	@Override
	public List<Flight> listFlightsByAirline(AirLine airline) {
		//Get the builder 
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		
		//Create the query
		CriteriaQuery<Flight> query = builder.createQuery(Flight.class);
		
		//get root path anf fill the where clause
		Root<Flight> root = query.from(Flight.class);
		 query.where(builder.equal(root.get("airLine"), airline));
		
		 //create query and return
		 return manager.createQuery(query).getResultList();
	}
	

}
