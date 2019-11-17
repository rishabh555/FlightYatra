package com.mytechtra.spring.FlightYatra.core.flightservice.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mytechtra.spring.FlightYatra.model.Flight;
import com.mytechtra.spring.FlightYatra.model.Flight.AirLine;

@Component
public class FlightRowMapper implements RowMapper<Flight> {

	@Override
	public Flight mapRow(ResultSet rs, int index) throws SQLException {
		Flight flight = new Flight();
		flight.setFlightId(rs.getInt("flight_id"));
		flight.setFligtName(rs.getString("flight_name"));
		flight.setCapacity(rs.getInt("capacity"));
		flight.setAirLine(AirLine.valueOf(rs.getString("airline")));
		return flight;
	}
		
}	