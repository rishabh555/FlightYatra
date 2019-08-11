package com.mytechtra.spring.FlightYatra.service;

import java.util.List;

import com.mytechtra.spring.FlightYatra.model.Flight;
import com.mytechtra.spring.FlightYatra.model.Flight.AirLine;

/**
 * Flight service is used to register/unregister the fight
 * @author Admin
 *
 */
public interface FlightService {
	
	void register(Flight fight);
	
	Flight getFlightById(long flightId);
	
	List<Flight> listAllFlightsByGivenAirLine(AirLine airLine);
	
	boolean unregister(long flightId);
	

}
