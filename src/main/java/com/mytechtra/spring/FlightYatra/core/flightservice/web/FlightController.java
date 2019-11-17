package com.mytechtra.spring.FlightYatra.core.flightservice.web;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mytechtra.spring.FlightYatra.core.flightservice.FlightService;
import com.mytechtra.spring.FlightYatra.core.flightservice.web.aspect.Timmer;
import com.mytechtra.spring.FlightYatra.model.Flight;
import com.mytechtra.spring.FlightYatra.model.Flight.AirLine;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Authorization;


@RestController
@RequestMapping("/FYatra/flights")
public class FlightController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FlightController.class);
	 
	@Autowired
	private FlightService flightService;
	
	//WARN, INFO ,DEBUG ,ERROR ,TRACE
	
	@Timmer
	@GetMapping(produces= {MediaType.APPLICATION_XML_VALUE})
	//@Secured("ROLE_ADMIN") any one is fine
	//@RolesAllowed("ROLE_ADMIN")
	@PreAuthorize(value = "hasRole('ROLE_USER')")
	//@RequestMapping(path = "/list",method =RequestMethod.GET)
	@ApiOperation(authorizations = {@Authorization("basicAuth")}, value = "" ,notes ="used to get all flights for airline" )
	public @ResponseBody List<Flight> flights( @RequestParam("air_line") AirLine airLine){
		
		return flightService.listAllFlightsByGivenAirLine(airLine);
	}
	
	@Timmer
	@GetMapping(produces= {MediaType.APPLICATION_JSON_VALUE})
	@RolesAllowed("ROLE_ADMIN")
	//@RequestMapping(path = "/list",method =RequestMethod.GET)
	public @ResponseBody List<Flight> flightsJson(@RequestParam("air_line") AirLine airLine){
		LOGGER.warn("XML warn {} {} {}" , "j" ,"67" ,8);
		LOGGER.info("XML info");
		LOGGER.debug("XML debug" );
		LOGGER.error("XML error");
		LOGGER.trace("XML trace");
		return flightService.listAllFlightsByGivenAirLine(airLine);
	}
	
	@Timmer
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody String save(@Valid @RequestBody Flight flight) {
		System.out.println("save json");
		flightService.register(flight);
		return "SUCCESS";
		
	}

	@Timmer
	@PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE})
	public @ResponseBody String saveXML(@RequestBody Flight flight) {
		System.out.println("save xml"); 
		flightService.register(flight);
		return "SUCCESS";
		
	}
	
	@Timmer
	@GetMapping(path = "/{flight_id}" , produces = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody Flight getFlight(@PathVariable("flight_id") Integer flightId) {
		return flightService.getFlightById(flightId);
		
	}
	
	@Timmer
	@PutMapping(path = "/{flight_id}" , consumes = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody String updateFlight(@PathVariable("flight_id") Integer flightId ,@RequestBody Flight flight) {
		System.out.println("save json"); 
		flightService.update(flight);
		return "SUCCESS";
		
	}
	
	@Timmer
	@DeleteMapping(path = "/{flight_id}" , consumes = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody String delete(@PathVariable("flight_id") Integer flightId ) {
		flightService.unregister(flightId);
		return "SUCCESS";
		
	}
	
}