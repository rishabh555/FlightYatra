package com.mytechtra.spring.FlightYatra.core.booking;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mytechtra.spring.FlightYatra.UserException.FlightNotAvailableException;
import com.mytechtra.spring.FlightYatra.UserException.NoTicketException;
import com.mytechtra.spring.FlightYatra.core.flightservice.FlightService;
import com.mytechtra.spring.FlightYatra.core.inventory.Inventory;
import com.mytechtra.spring.FlightYatra.core.pricing.Pricing;
import com.mytechtra.spring.FlightYatra.model.Booking;
import com.mytechtra.spring.FlightYatra.model.Flight;
import com.mytechtra.spring.FlightYatra.model.Ticket;
import com.mytechtra.spring.FlightYatra.model.Ticket.TicketType;

@Component
public class BookFlightimpl implements BookFlights  {
	
	@Autowired
	private FlightService flightService;
	
	@Autowired
	private Inventory inventoryService;
	
	@Autowired
	private Pricing pricing;
	

	@Override
	public Booking book(long flightId, TicketType ticketType, Date date, int count) throws NoTicketException,FlightNotAvailableException {
		Flight flight = flightService.getFlightById(flightId);
		if (flight !=null) 
		{
			Booking booking = new Booking();
			booking.setFlight(flight);
			List<Ticket> tickets = inventoryService.getTickets(flightId, ticketType, date, count);
			if(tickets !=null) {
				booking.setTicktes(tickets);
				booking.setDateOfBooking(new Date());
				booking.setBookingDate(date);
				pricing.price(booking);
				return booking;
			} else {
				throw new NoTicketException("No Tickets");
			}
			
		}
		else 
		{
			throw new FlightNotAvailableException ("Flight not available with requested id"); 
		}

	}

}
