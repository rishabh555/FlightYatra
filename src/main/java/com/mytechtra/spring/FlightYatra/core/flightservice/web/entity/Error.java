package com.mytechtra.spring.FlightYatra.core.flightservice.web.entity;

public class Error {
	
	private int errorCode;
	
	private String errMsg;

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
}
