package com.mytechtra.spring.FlightYatra.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.mytechtra.spring.FlightYatra.model.Flight;
import com.mytechtra.spring.FlightYatra.model.Flight.AirLine;

@Component
public class FlightServiceInMemoryImpl implements FlightService {
	
	Map<Long,Flight> flightdb =new HashMap();

	@Override
	public void register(Flight fight) {
		 
		flightdb.put(fight.getFlightId(), fight);		
	}

	@Override
	public Flight getFlightById(long flightId) {	
		
		return flightdb.get(flightId);
	}

	@Override
	public List<Flight> listAllFlightsByGivenAirLine(AirLine airLine) {
		
		List<Flight> flight= new ArrayList<>(flightdb.values());		
		Iterator<Flight> itr = flight.iterator();
	     while(itr.hasNext()) {
	    	 Flight fl =(Flight) itr.next();
	    	 if(fl.getAirLine() != airLine) {
	    		 itr.remove();
	    	 }
	     }
		
		return flight;
	}

	@Override
	public boolean unregister(long flightId) {
		boolean removed = flightdb.remove(flightId) != null;
		return removed;
	}
	
}


