package com.mytechtra.spring.FlightYatra.core.web;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.Test;
import org.springframework.boot.web.client.ClientHttpRequestFactorySupplier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.mytechtra.spring.FlightYatra.model.Flight;
import com.mytechtra.spring.FlightYatra.model.Flight.AirLine;

public class IntegrationTest {
	
	@Test
	public void testIntegration() throws RestClientException, URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setBasicAuth("admin", "admin123");
		
		HttpEntity<Flight> entity = new HttpEntity<Flight>(headers);

		
		ResponseEntity<String> result =  restTemplate.exchange(new URI("http://localhost:8080/flights"), HttpMethod.GET,entity , String.class);
		System.out.println(result.getBody());
	}
	
	@Test
	public void testIntegrationDataRest() throws RestClientException, URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(new URI("http://localhost:8080/flights"), String.class);
		System.out.println(result);
	}
	
	
	@Test
	public void testPostIntegration() throws RestClientException, URISyntaxException {
		
		RestTemplate restTemplate = new RestTemplate();
		Flight flight =new Flight();
		flight.setAirLine(AirLine.SPICEJET);
		flight.setCapacity(20);
		flight.setFligtName("Spice38008");
		flight.setFlightId(2209);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setBasicAuth("admin", "admin123");
		
		HttpEntity<Flight> entity = new HttpEntity<Flight>(flight,headers);

		ResponseEntity<String> result = restTemplate.postForEntity(new URI("http://localhost:8080/FYatra/flights"),entity,String.class);
		System.out.println(result.getStatusCodeValue());
		System.out.println(result.getBody());

	}
}


