package com.mytechtra.spring.FlightYatra.core.flightservice.web.datarest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mytechtra.spring.FlightYatra.model.Flight;


@RepositoryRestResource(collectionResourceRel="flights" , path = "/datarest")
public interface FlightDataRest extends PagingAndSortingRepository<Flight, Long>  {

}
