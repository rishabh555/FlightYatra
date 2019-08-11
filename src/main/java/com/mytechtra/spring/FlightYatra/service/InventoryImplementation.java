package com.mytechtra.spring.FlightYatra.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mytechtra.spring.FlightYatra.model.Flight;
import com.mytechtra.spring.FlightYatra.model.Ticket;
import com.mytechtra.spring.FlightYatra.model.Ticket.TicketType;

@Component
public class InventoryImplementation implements Inventory {

	@Autowired
	private FlightService flightService;

	private List<Ticket> ticktes = new ArrayList<>();

	@Override
	public void loadTickets(long flightId, TicketType ticketType, Date date, double price, int count) throws Exception {
		Flight result = flightService.getFlightById(flightId);
		if (result != null) {
			for (int i = 0; i < count; i++) {
				Ticket ticket = new Ticket();
				ticket.setFlight(result);
				ticket.setTicketType(ticketType);
				ticket.setCost(price);
				ticket.setDateTime(date);
				ticket.setTicketId(new Random().nextLong());
				ticktes.add(ticket);
			}
		} else {
			throw new Exception("Flight not found");
		}
	}

	@Override
	public List<Ticket> getTickets(long flightId, TicketType ticketType, Date date, int count) {
		List<Ticket> result = ticktes.stream().filter(x -> x.getFlight().getFlightId() == flightId)
				.filter(ticket -> ticket.getTicketType() == ticketType)
				.filter(ticket -> DateUtils.isSameDay(ticket.getDateTime(), date)).collect(Collectors.toList());

		if (result.size() > count) {
			ticktes.removeAll(result);
			return result;
		}
		return null;
	}

}
