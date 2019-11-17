package com.mytechtra.spring.FlightYatra.core.inventory;

import java.util.Date;
import java.util.List;

import com.mytechtra.spring.FlightYatra.model.Ticket;
import com.mytechtra.spring.FlightYatra.model.Ticket.TicketType;

public interface Inventory {
	
	void loadTickets(long flightId , TicketType ticketType , Date date, double price , int count) throws Exception;
	
	List<Ticket> getTickets(long flightId ,TicketType ticketType , Date date ,int count);

}
