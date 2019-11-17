package com.mytechtra.spring.FlightYatra.core.flightservice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.mytechtra.spring.FlightYatra.core.flightservice.dao.FlightDao;
import com.mytechtra.spring.FlightYatra.model.Flight;
import com.mytechtra.spring.FlightYatra.model.Flight.AirLine;

@Component
@Primary
@Transactional
public class FlightServiceWithDao implements FlightService{

	@Autowired
	private FlightDao flightDao;
	
	@Override
	public void register(Flight flight) {
		flightDao.save(flight);
	}

	@Override
	public Flight getFlightById(long flightId) {
		return flightDao.getFlight(flightId);
	}

	@Override
	public List<Flight> listAllFlightsByGivenAirLine(AirLine airLine) {
		/*List<Flight> flight= flightDao.listFlights();		
		Iterator<Flight> itr = flight.iterator();
	     while(itr.hasNext()) {
	    	 Flight fl =(Flight) itr.next();
	    	 if(fl.getAirLine() != airLine) {
	    		 itr.remove();
	    	 }
	     }
		*/
		return flightDao.listFlightsByAirline(airLine);
	}

	@Override
	public boolean unregister(long flightId) {
		
		return flightDao.delete(flightDao.getFlight(flightId));
	}

	@Override
	public boolean update(Flight flight) {
		 flightDao.update(flight);
		 return true;
	}

}
