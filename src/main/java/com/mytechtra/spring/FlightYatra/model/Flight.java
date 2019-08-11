package com.mytechtra.spring.FlightYatra.model;

import java.util.Date;

public class Flight {
	
	private long flightId;
	
	private String fligtName;
	
	public enum AirLine {INDIGO , SPICEJET};
	
	private AirLine airLine;
	
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
