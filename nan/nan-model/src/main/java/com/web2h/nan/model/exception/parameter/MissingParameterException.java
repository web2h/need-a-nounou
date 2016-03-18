package com.web2h.nan.model.exception.parameter;

/**
 * Missing parameter exception. Occurs when a parameter is missing although it is mandatory.
 * 
 * @author web2h
 */
@SuppressWarnings("serial")
public class MissingParameterException extends ParameterException {
	
	private static final String MESSAGE = "The {0} parameter is missing or empty";

	public MissingParameterException() {
		super();
	}
	
	public MissingParameterException(String missingParameter) {
		super(MESSAGE.replace("{0}", missingParameter));
	}
}