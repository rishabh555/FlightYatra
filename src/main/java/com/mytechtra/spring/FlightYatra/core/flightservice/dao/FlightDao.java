package com.mytechtra.spring.FlightYatra.core.flightservice.dao;

import java.util.List;

import com.mytechtra.spring.FlightYatra.model.Flight;
import com.mytechtra.spring.FlightYatra.model.Flight.AirLine;

public interface FlightDao {
	
	Flight getFlight(Long id);
	 
	void save(Flight flight);
	
	void update(Flight flight);
	
	boolean delete(Flight flight);
	
	List<Flight> listFlights();
	
	List<Flight> listFlightsByAirline(AirLine airline);

		
	}
