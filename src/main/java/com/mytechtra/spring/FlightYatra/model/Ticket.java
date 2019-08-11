package com.mytechtra.spring.FlightYatra.model;

import java.util.Date;

public class Ticket {
	
	private long ticketId;
	
	private Flight flight;
	
	public enum TicketType {BUSNISS, ECONOMY};
	
	private TicketType ticketType;
	
	private Date  dateTime;
	
	private double cost;

	public long getTicketId() {
		return ticketId;
	}

	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}

	public TicketType getTicketType() {
		return ticketType;
	}

	public void setTicketType(TicketType ticketType) {
		this.ticketType = ticketType;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	
}
