package com.mytechtra.spring.FlightYatra.core.flightservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mytechtra.spring.FlightYatra.model.Flight;
import com.mytechtra.spring.FlightYatra.model.Flight.AirLine;

@Repository
public interface FlightDaoRepository extends JpaRepository<Flight, Long > {

	@Query(name = "getFlightsByAirline")
	List<Flight> getAllFlightsByAirline(AirLine airline);
}
