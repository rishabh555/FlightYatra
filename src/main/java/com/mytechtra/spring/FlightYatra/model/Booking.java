package com.mytechtra.spring.FlightYatra.model;

import java.util.Date;
import java.util.List;

public class Booking {
	
	private Flight flight;
	
	private List<Ticket> ticktes;
	
	private String userName;
	
	private Date dateOfBooking;
	
	private Date bookingDate;
	
	private Price price;

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public List<Ticket> getTicktes() {
		return ticktes;
	}

	public void setTicktes(List<Ticket> ticktes) {
		this.ticktes = ticktes;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getDateOfBooking() {
		return dateOfBooking;
	}

	public void setDateOfBooking(Date dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	


}
