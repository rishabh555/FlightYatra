package com.mytechtra.spring.FlightYatra.core.flightservice;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.mytechtra.spring.FlightYatra.core.flightservice.FlightService;
import com.mytechtra.spring.FlightYatra.core.flightservice.FlightServiceInMemoryImpl;
import com.mytechtra.spring.FlightYatra.model.Flight;
import com.mytechtra.spring.FlightYatra.model.Flight.AirLine;

public class FlightServiceTest {

	@Test
	public void testRegisterFlight() {
		
		FlightService flightService =new FlightServiceInMemoryImpl();
		
		Flight flight= new Flight();
		flight.setAirLine(AirLine.INDIGO);
		flight.setCapacity(100);
		flight.setFlightId(1);
		flight.setFligtName("RM");
		
		flightService.register(flight);
		
		Flight result = flightService.getFlightById(flight.getFlightId());
		
		Assert.assertNotNull(result);
		Assert.assertEquals(flight.getFlightId(), result.getFlightId());
		Assert.assertEquals(flight.getAirLine(), result.getAirLine());
		Assert.assertEquals(flight.getCapacity(), result.getCapacity());
		Assert.assertEquals(flight.getFligtName(), result.getFligtName());
		
		List<Flight> flightlist=  flightService.listAllFlightsByGivenAirLine(flight.getAirLine());		
		Assert.assertNotNull(flightlist);
		Assert.assertEquals(flightlist.get(0).getAirLine(), flight.getAirLine());
		
		List<Flight> flightlist2=  flightService.listAllFlightsByGivenAirLine(AirLine.SPICEJET);
		Assert.assertEquals(flightlist2.size(),0);
		
		boolean resultflag =flightService.unregister(flight.getFlightId());
		Assert.assertNotNull(resultflag);
		Assert.assertEquals(true, resultflag);

		boolean resultflag2 =flightService.unregister(2);
		Assert.assertEquals(false, resultflag2);

		
	}
}