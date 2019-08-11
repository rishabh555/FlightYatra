package com.mytechtra.spring.FlightYatra.service;

import java.util.Date;

import com.mytechtra.spring.FlightYatra.model.Booking;
import com.mytechtra.spring.FlightYatra.model.Ticket.TicketType;

public interface BookFlights {
	
	Booking book(long flightId, TicketType ticketType, Date date, int count) throws Exception;
	

}
