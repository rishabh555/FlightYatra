package com.mytechtra.spring.FlightYatra.core.pricing;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mytechtra.spring.FlightYatra.model.Booking;
import com.mytechtra.spring.FlightYatra.model.Price;
import com.mytechtra.spring.FlightYatra.model.Ticket;

@Component
public class GSTPricing implements Pricing {

	@Value("${gov.gst.tax}")
	private double taxPercentage;
	
	
	@Override
	public void price(Booking booking) {
		List<Ticket> ticktes = booking.getTicktes();
		double totalPrice = 0;
		for(Ticket ticket : ticktes) {
			totalPrice = totalPrice + ticket.getCost();
		}
		
		double tax = totalPrice * taxPercentage;
		Price price =new Price();
		price.setAmount(totalPrice);
		price.setTax(tax);
		price.setTotalAmount(totalPrice + tax);
		booking.setPrice(price);
	}

}
