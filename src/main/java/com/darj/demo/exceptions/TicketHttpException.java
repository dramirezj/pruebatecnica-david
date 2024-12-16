package com.darj.demo.exceptions;

import lombok.Getter;

@Getter
public class TicketHttpException extends RuntimeException {
	
	private final int httpCode;

	private final String errorCode;

	private final String message;

	public TicketHttpException(int httpCode, String errorCode, String message) {
		super(message);
		this.httpCode = httpCode;
		this.message = message;
		this.errorCode = errorCode;
	}

	public TicketHttpException(int httpCode, String errorCode, String message, Throwable throwable) {
		super(message, throwable);
		this.httpCode = httpCode;
		this.message = message;
		this.errorCode = errorCode;
	}
	
	private static final long serialVersionUID = 4974776099812651590L;	

}
