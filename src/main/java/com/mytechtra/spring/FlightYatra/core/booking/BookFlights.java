package com.mytechtra.spring.FlightYatra.core.booking;

import java.util.Date;

import com.mytechtra.spring.FlightYatra.UserException.FlightNotAvailableException;
import com.mytechtra.spring.FlightYatra.UserException.NoTicketException;
import com.mytechtra.spring.FlightYatra.model.Booking;
import com.mytechtra.spring.FlightYatra.model.Ticket.TicketType;

public interface BookFlights {
	
	Booking book(long flightId, TicketType ticketType, Date date, int count) throws NoTicketException,FlightNotAvailableException;
	

}
