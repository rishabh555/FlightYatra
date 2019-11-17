package com.mytechtra.spring.FlightYatra.core.flightservice.web;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mytechtra.spring.FlightYatra.UserException.FlightNotAvailableException;
import com.mytechtra.spring.FlightYatra.UserException.NoTicketException;
import com.mytechtra.spring.FlightYatra.core.booking.BookFlights;
import com.mytechtra.spring.FlightYatra.core.flightservice.FlightService;
import com.mytechtra.spring.FlightYatra.core.flightservice.web.entity.Error;
import com.mytechtra.spring.FlightYatra.core.flightservice.web.entity.ResponseWrapper;
import com.mytechtra.spring.FlightYatra.core.flightservice.web.entity.ResponseWrapper.Status;
import com.mytechtra.spring.FlightYatra.model.Booking;
import com.mytechtra.spring.FlightYatra.model.Flight;
import com.mytechtra.spring.FlightYatra.model.Flight.AirLine;
import com.mytechtra.spring.FlightYatra.model.Ticket.TicketType;
import com.mytechtra.spring.FlightYatra.pojo.FlightPojo;

@RestController
@RequestMapping("/TYatra/tickets")
public class TicketesController {
	
	@Autowired
	private BookFlights BookFlightsservice;
	
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ResponseWrapper<?> save(@RequestBody FlightPojo FlightPojo) throws NoTicketException, FlightNotAvailableException  {
			ResponseWrapper<String> success = new ResponseWrapper<>();
			BookFlightsservice.book(FlightPojo.getFlightId(),FlightPojo.getTicketType(),FlightPojo.getDateTime(),FlightPojo.getCount());
			success.setReponse("added succesfully");
			success.setStatus(Status.SUCCESS);
			return success;
	}
	
	

}