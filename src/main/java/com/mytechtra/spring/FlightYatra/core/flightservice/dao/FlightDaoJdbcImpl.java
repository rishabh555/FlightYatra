package com.mytechtra.spring.FlightYatra.core.flightservice.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mytechtra.spring.FlightYatra.model.Flight;
import com.mytechtra.spring.FlightYatra.model.Flight.AirLine;


public class FlightDaoJdbcImpl implements  FlightDao{
	
	@Autowired
	private JdbcTemplate template;
	
	@Autowired
	private RowMapper<Flight> mapper;

	private static final String GET_FLIGHT = "SELECT * FROM flights where flight_id = ?";
	
	private static final String Insert_FLIGHT = "insert into flights values (?,?,?,?)";
	
	private static final String Update_FLIGHT = "update flights set flight_name=?,airline=?,capacity=? where flight_id=?";
	
	private static final String delete_FLIGHT = "delete from flights where flight_id=?";
	
	private static final String select_FLIGHT = "SELECT * FROM flights";
	
	@Override
	public Flight getFlight(Long id) {
		return template.query(GET_FLIGHT, new Object[] {id}, mapper).get(0);
	}

	@Override
	public void save(Flight flight) {
    template.update(Insert_FLIGHT, flight.getFlightId(),flight.getFligtName(),flight.getAirLine().toString(),flight.getCapacity());
		
	}

	@Override
	public void update(Flight flight) {
	template.update(Update_FLIGHT,flight.getFligtName(),flight.getAirLine(),flight.getCapacity(),flight.getFlightId());
		
	}

	@Override
	public boolean delete(Flight flight) {
		template.update(delete_FLIGHT, flight.getFlightId());  
		return false;
	}

	@Override
	public List<Flight> listFlights() {
		return template.query(select_FLIGHT, mapper);
		
	}

	@Override
	public List<Flight> listFlightsByAirline(AirLine airline) {
		throw new UnsupportedOperationException();
	}

}
