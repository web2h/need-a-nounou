package com.web2h.nan.model.exception.parameter;

/**
 * Parameter exception. Occurs when a parameter is not what it is expected to be (missing, wrong format, ...).
 * 
 * @author web2h
 */
@SuppressWarnings("serial")
public class ParameterException extends Exception {

	public ParameterException() {
		super();
	}
	
	public ParameterException(String message) {
		super(message);
	}
}