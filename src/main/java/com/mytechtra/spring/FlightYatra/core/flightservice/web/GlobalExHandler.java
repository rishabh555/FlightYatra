package com.mytechtra.spring.FlightYatra.core.flightservice.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mytechtra.spring.FlightYatra.UserException.FlightNotAvailableException;
import com.mytechtra.spring.FlightYatra.UserException.NoTicketException;
import com.mytechtra.spring.FlightYatra.core.flightservice.web.entity.Error;
import com.mytechtra.spring.FlightYatra.core.flightservice.web.entity.ResponseWrapper;
import com.mytechtra.spring.FlightYatra.core.flightservice.web.entity.ResponseWrapper.Status;

@ControllerAdvice
public class GlobalExHandler {
	
	@ExceptionHandler(value = NoTicketException.class)
	public @ResponseBody ResponseWrapper<?> handleException(Exception ex){
			ResponseWrapper<Error> error = new ResponseWrapper<>();
			Error err = new Error();
			err.setErrorCode(11404);
			err.setErrMsg(ex.getMessage());
			error.setReponse(err);
			error.setStatus(Status.FAILURE);
			return error;
	}
	
	@ExceptionHandler(value = FlightNotAvailableException.class)
	public @ResponseBody ResponseWrapper<?> handleFNAException(Exception ex){
			ResponseWrapper<Error> error = new ResponseWrapper<>();
			Error err = new Error();
			err.setErrorCode(13404);
			err.setErrMsg(ex.getMessage());
			error.setReponse(err);
			error.setStatus(Status.FAILURE);
			return error;
	}

}
