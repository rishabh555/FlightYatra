package com.mytechtra.spring.FlightYatra.core.flightservice.web.entity;

public class ResponseWrapper<T> {
	 
	private T reponse;

	public enum Status {SUCCESS ,FAILURE ,ERROR};
	
	private Status status;

	public T getReponse() {
		return reponse;
	}

	public void setReponse(T reponse) {
		this.reponse = reponse;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
