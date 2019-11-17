package com.mytechtra.spring.FlightYatra.core.inventory;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.mytechtra.spring.FlightYatra.core.flightservice.FlightService;
import com.mytechtra.spring.FlightYatra.core.inventory.InventoryImplementation;
import com.mytechtra.spring.FlightYatra.model.Flight;
import com.mytechtra.spring.FlightYatra.model.Ticket.TicketType;

@RunWith(MockitoJUnitRunner.class)
public class InventoryTest {
	
	@Mock
	FlightService flightService;
	
	@InjectMocks
	InventoryImplementation inventory;
	
	@Test
	public void testLoadTickets() throws Exception {
		Mockito.when(flightService.getFlightById(1)).thenReturn(new Flight());
		inventory.loadTickets(1, TicketType.BUSNISS, new Date(), 10.0, 5);
	}
	
	@Test(expected=Exception.class)
	public void testLoadTicketsNoFlight() throws Exception {
		inventory.loadTickets(1, TicketType.BUSNISS, new Date(), 10.0, 5);
	}
}

