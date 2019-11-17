package com.mytechtra.spring.FlightYatra.core.web;

import java.net.URI;
import java.util.Arrays;

import javax.validation.Valid;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mytechtra.spring.FlightYatra.core.flightservice.FlightService;
import com.mytechtra.spring.FlightYatra.core.flightservice.web.FlightController;
import com.mytechtra.spring.FlightYatra.model.Flight;
import com.mytechtra.spring.FlightYatra.model.Flight.AirLine;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = { FlightController.class })
public class FlightControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private FlightService service;

	@Before
	public void setUp() {

		Flight flight1 = new Flight();
		flight1.setAirLine(AirLine.INDIGO);
		flight1.setCapacity(9);
		flight1.setFlightId(101);
		flight1.setFligtName("Indigo101");

		Flight flight2 = new Flight();
		flight2.setAirLine(AirLine.SPICEJET);
		flight2.setCapacity(11);
		flight2.setFlightId(102);
		flight2.setFligtName("SpiceJet102");

		Flight flight3 = new Flight();
		flight3.setAirLine(AirLine.SPICEJET);
		flight3.setCapacity(14);
		flight3.setFlightId(103);
		flight3.setFligtName("SpiceJet103");

		Mockito.when(service.listAllFlightsByGivenAirLine(AirLine.SPICEJET))
				.thenReturn(Arrays.asList(flight2, flight3));
		Mockito.when(service.listAllFlightsByGivenAirLine(AirLine.INDIGO)).thenReturn(Arrays.asList(flight1));

	}

	
	@Test
	public void testByAirline() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get(URI.create("/FYatra/flights"))
				.param("air_line", "SPICEJET")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
		.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
		.andExpect(MockMvcResultMatchers.jsonPath("$[0].flightId").value(102))
		.andExpect(MockMvcResultMatchers.jsonPath("$[1].flightId").value(103));

	}
	
	
	@Test
	public void testBypostAirline() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post(URI.create("/FYatra/flights"))
				.content("{\r\n" + 
						"        \"flightId\": 12," + 
						"        \"fligtName\": \"SIMBA\"," + 
						"        \"airLine\": \"SPICEJET\"," + 
						"        \"capacity\": 15" + 
						"    }")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
		Mockito.verify(service).register(Mockito.any());

	}
	
	/*@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody String save(@Valid @RequestBody Flight flight) {
		System.out.println("save json");
		flightService.register(flight);
		return "SUCCESS";*/
		
	}
	
	
	
	
	
	

