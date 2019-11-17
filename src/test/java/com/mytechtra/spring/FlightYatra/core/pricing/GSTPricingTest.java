package com.mytechtra.spring.FlightYatra.core.pricing;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mytechtra.spring.FlightYatra.core.pricing.GSTPricing;
import com.mytechtra.spring.FlightYatra.core.pricing.Pricing;
import com.mytechtra.spring.FlightYatra.model.Booking;
import com.mytechtra.spring.FlightYatra.model.Ticket;
import com.mytechtra.spring.FlightYatra.model.Ticket.TicketType;

@RunWith(value = SpringJUnit4ClassRunner.class)
@SpringJUnitConfig(GSTPricingTest.class)
@PropertySource("classpath:test.properties")
@Configuration
public class GSTPricingTest {
	
	@Bean
	public Pricing  getPricing() {
		return new GSTPricing();
	}
	
	@Autowired
	private Pricing pricing ; 
	
	@Test
	public void gstTest() {
		Booking booking = new Booking();
		
		Ticket ticket= new Ticket();
		ticket.setCost(10);
		ticket.setTicketType(TicketType.BUSNISS);
		
		Ticket ticket2= new Ticket();
		ticket2.setCost(10);
		ticket2.setTicketType(TicketType.BUSNISS);
		
		Ticket ticket3= new Ticket();
		ticket3.setCost(10);
		ticket3.setTicketType(TicketType.BUSNISS);
		
		List<Ticket> tickets = new ArrayList<>();
		tickets.add(ticket);
		tickets.add(ticket2);
		tickets.add(ticket3);
		
		booking.setTicktes(tickets);
		
		pricing.price(booking);
		
		Assert.assertNotNull(booking.getPrice());
		Assert.assertEquals(30.0, booking.getPrice().getAmount(),0.0);
		Assert.assertEquals(3.0, booking.getPrice().getTax(),0.0);
		Assert.assertEquals(33.0, booking.getPrice().getTotalAmount(),0.0);
		
	}


}
