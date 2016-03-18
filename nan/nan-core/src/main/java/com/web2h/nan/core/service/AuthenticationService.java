package com.web2h.nan.core.service;

import com.web2h.nan.model.exception.parameter.ParameterException;
import com.web2h.nan.model.request.RequestParameters;

/**
 * Authentication service interface.
 * 
 * @author web2h
 */
public interface AuthenticationService {

	/**
	 * Authenticate a request sent by the user.
	 * 
	 * @param parameters HTTP parameters sent by the user
	 * @throws ParameterException Thrown when at least on the parameters is not what it is expected to be (missing, wrong format, ...)
	 */
	void authenticateRequest(RequestParameters parameters) throws ParameterException;	
}