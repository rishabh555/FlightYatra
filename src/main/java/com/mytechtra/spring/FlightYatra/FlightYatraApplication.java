package com.mytechtra.spring.FlightYatra;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.mytechtra.spring.FlightYatra.model.Booking;
import com.mytechtra.spring.FlightYatra.model.Flight;
import com.mytechtra.spring.FlightYatra.model.Flight.AirLine;
import com.mytechtra.spring.FlightYatra.model.Ticket.TicketType;
import com.mytechtra.spring.FlightYatra.service.BookFlightimpl;
import com.mytechtra.spring.FlightYatra.service.BookFlights;
import com.mytechtra.spring.FlightYatra.service.FlightService;
import com.mytechtra.spring.FlightYatra.service.FlightServiceInMemoryImpl;
import com.mytechtra.spring.FlightYatra.service.Inventory;
import com.mytechtra.spring.FlightYatra.service.InventoryImplementation;


@SpringBootApplication
public class FlightYatraApplication {

	public static void main(String[] args) throws Exception {
		
		
		ConfigurableApplicationContext ctx = SpringApplication.run(FlightYatraApplication.class, args);	
		
		System.out.println("====Adding Flight------");
		Flight flight1 =new Flight();
		flight1.setAirLine(AirLine.INDIGO);
		flight1.setCapacity(9);
		flight1.setFlightId(101);
		flight1.setFligtName("Indigo101");
		
		Flight flight2 =new Flight();
		flight2.setAirLine(AirLine.SPICEJET);
		flight2.setCapacity(11);
		flight2.setFlightId(102);
		flight2.setFligtName("SpiceJet102");	
		FlightService flightService =ctx.getBean(FlightServiceInMemoryImpl.class);
		
		
		
		flightService.register(flight1);
		flightService.register(flight2);
		
		System.out.println("====Load Tickets------");	
          Inventory inventoryTickets = ctx.getBean(InventoryImplementation.class);	
          inventoryTickets.loadTickets(101, TicketType.ECONOMY, new Date(), 4412, 60);
          inventoryTickets.loadTickets(102, TicketType.BUSNISS, new Date(), 5402, 40);
		
		System.out.println("====Flight Booking------");		
		BookFlights bookingFlight = ctx.getBean(BookFlightimpl.class);			
		Booking b1  =bookingFlight.book(101,TicketType.ECONOMY, new Date(), 1);
		System.out.println("Your booking is confirmed ,Yours ticket Price is = "+b1.getPrice().getTotalAmount()
				+"Booking date is "+b1.getBookingDate()+"Date of booking is "+b1.getDateOfBooking());
		
		
		
		
	}

}
