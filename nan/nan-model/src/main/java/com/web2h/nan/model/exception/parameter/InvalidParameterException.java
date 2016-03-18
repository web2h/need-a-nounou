package com.web2h.nan.model.exception.parameter;

/**
 * Invalid parameter exception. Occurs when a parameter does not match the required format.
 * 
 * @author web2h
 */
@SuppressWarnings("serial")
public class InvalidParameterException extends ParameterException {
	
	private static final String MESSAGE = "The {0} parameter is invalid";

	public InvalidParameterException() {
		super();
	}
	
	public InvalidParameterException(String invalidParameter) {
		super(MESSAGE.replace("{0}", invalidParameter));
	}
}