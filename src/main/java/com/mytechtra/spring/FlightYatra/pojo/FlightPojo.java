package com.mytechtra.spring.FlightYatra.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mytechtra.spring.FlightYatra.model.Ticket.TicketType;

public class FlightPojo {
	
private long flightId;

private int count;

private TicketType ticketType;

@JsonFormat(pattern = "dd-MM-yyyy")
private Date  dateTime;

public long getFlightId() {
	return flightId;
}

public void setFlightId(long flightId) {
	this.flightId = flightId;
}

public int getCount() {
	return count;
}

public void setCount(int count) {
	this.count = count;
}

public TicketType getTicketType() {
	return ticketType;
}

public void setTicketType(TicketType ticketType) {
	this.ticketType = ticketType;
}

public Date getDateTime() {
	return dateTime;
}

public void setDateTime(Date dateTime) {
	this.dateTime = dateTime;
}



}
