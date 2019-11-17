package com.mytechtra.spring.FlightYatra.core.flightservice;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.mytechtra.spring.FlightYatra.core.flightservice.dao.FlightDaoRepository;
import com.mytechtra.spring.FlightYatra.model.Flight;
import com.mytechtra.spring.FlightYatra.model.Flight.AirLine;

@Component
public class FlightServiceWithRepo implements FlightService {
	
	@Autowired
	private FlightDaoRepository daoRepository;

	@Override
	public void register(Flight fight) {
		daoRepository.save(fight);
	}

	@Override
	public Flight getFlightById(long flightId) {
		return daoRepository.getOne(flightId);
	}

	@Override
	public List<Flight> listAllFlightsByGivenAirLine(AirLine airLine) {
		return daoRepository.getAllFlightsByAirline(airLine);
	}

	@Override
	public boolean unregister(long flightId) {
	 daoRepository.deleteById(flightId);
	 return true;
	}

	@Override
	public boolean update(Flight flight) {
		daoRepository.save(flight);
		return true;
	}

}
