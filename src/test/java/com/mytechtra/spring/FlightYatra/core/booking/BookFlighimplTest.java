package com.mytechtra.spring.FlightYatra.core.booking;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.mytechtra.spring.FlightYatra.UserException.FlightNotAvailableException;
import com.mytechtra.spring.FlightYatra.UserException.NoTicketException;
import com.mytechtra.spring.FlightYatra.core.booking.BookFlightimpl;
import com.mytechtra.spring.FlightYatra.core.flightservice.FlightService;
import com.mytechtra.spring.FlightYatra.core.inventory.Inventory;
import com.mytechtra.spring.FlightYatra.core.pricing.Pricing;
import com.mytechtra.spring.FlightYatra.model.Booking;
import com.mytechtra.spring.FlightYatra.model.Flight;
import com.mytechtra.spring.FlightYatra.model.Flight.AirLine;
import com.mytechtra.spring.FlightYatra.model.Ticket;
import com.mytechtra.spring.FlightYatra.model.Ticket.TicketType;

@RunWith(MockitoJUnitRunner.class)
public class BookFlighimplTest {	
	
	@Mock
	private FlightService flightService;	
	
	@Mock
	private Inventory inventoryService;	
	
	@Mock
	private Pricing pricing;
	
	@InjectMocks
	private BookFlightimpl bkflimpl;
	
	private Date date =	new Date();
	
	private Flight flight= new Flight();
	
	private List<Ticket> tickets = new ArrayList<>();
	
	@Before
	public void setUp() {
		
		flight.setAirLine(AirLine.INDIGO);
		flight.setCapacity(100);
		flight.setFlightId(1);
		flight.setFligtName("Rishi");
		
		Mockito.when(flightService.getFlightById(1)).thenReturn(flight);
		
		Ticket ticket= new Ticket();
		ticket.setTicketId(11);
		ticket.setFlight(flight);
		ticket.setCost(10);
		ticket.setTicketType(TicketType.BUSNISS);
		
		Ticket ticket2= new Ticket();
		ticket2.setTicketId(12);
		ticket2.setFlight(flight);
		ticket2.setCost(10);
		ticket2.setTicketType(TicketType.BUSNISS);
		
		Ticket ticket3= new Ticket();
		ticket3.setTicketId(13);
		ticket3.setFlight(flight);
		ticket3.setCost(10);
		ticket3.setTicketType(TicketType.BUSNISS);
		
		
		tickets.add(ticket);
		tickets.add(ticket2);
		tickets.add(ticket3);
		
		Mockito.when(inventoryService.getTickets(flight.getFlightId(), TicketType.BUSNISS, date, 3)).thenReturn(tickets);

	}
	
	@Test
	public void bookFlightTestHere () throws Exception {

	Booking booking = bkflimpl.book(1,TicketType.BUSNISS,date,3); 
	Assert.assertNotNull(booking);
	Assert.assertNotNull(booking.getFlight());
	Assert.assertEquals(flight.getFlightId(), booking.getFlight().getFlightId());
	Assert.assertNotNull(booking.getBookingDate());
	Assert.assertNotNull(booking.getTicktes());
	Assert.assertEquals(3, booking.getTicktes().size());
	
	Mockito.verify(pricing,Mockito.atLeast(1)).price(booking);
	
	
}
	
	@Test(expected=FlightNotAvailableException.class)
	public void bookFlightTestNoFlight () throws Exception {

	Booking booking = bkflimpl.book(2,TicketType.BUSNISS,date,3); 	
	
	
}
	
	@Test(expected=NoTicketException.class)
	public void bookFlightTestNoTicket () throws Exception {
    Mockito.when(inventoryService.getTickets(flight.getFlightId(), TicketType.BUSNISS, date, 3)).thenReturn(null);
	Booking booking = bkflimpl.book(1,TicketType.BUSNISS,date,3); 	
	
	
}

}
