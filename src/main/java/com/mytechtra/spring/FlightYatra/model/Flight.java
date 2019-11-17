package com.mytechtra.spring.FlightYatra.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.lang.NonNull;

@Entity
@Table (name="flights")
@NamedQueries({@NamedQuery(name ="getFlightsByAirline" ,query = "from Flight f where f.airLine = ?1"),
	@NamedQuery(name ="getAllFlights" ,query = "from Flight f")})
public class Flight {
	
	@Positive(message = "Cannot be negative or Zero")
	@Id
	@Column(name="flight_id")
	private long flightId;
	
	@NotBlank(message = "Cannot be empty")
	@Column	(name="flight_name")
	private String fligtName;
	
	
	public enum AirLine {INDIGO , SPICEJET};
	
	@NotNull(message = "Airline should be {INDIGO , SPICEJET}")
	@Column	(name="airline")
	@Enumerated(EnumType.STRING)
	private AirLine airLine;
	
	@Positive(message = "Cannot be negative or Zero")
	@Max(value =50 , message = "Cannot be more than 50")
	@Column	(name="capacity")
	private int capacity;
 
	public long getFlightId() {
		return flightId;
	}

	public void setFlightId(long flightId) {
		this.flightId = flightId;
	}

	public String getFligtName() {
		return fligtName;
	}

	public void setFligtName(String fligtName) {
		this.fligtName = fligtName;
	}

	public AirLine getAirLine() {
		return airLine;
	}

	public void setAirLine(AirLine airLine) {
		this.airLine = airLine;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
		
	
	
}
