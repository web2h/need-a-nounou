package com.web2h.nan.core.service;

import org.springframework.stereotype.Service;

import com.web2h.nan.model.exception.parameter.InvalidParameterException;
import com.web2h.nan.model.exception.parameter.MissingParameterException;
import com.web2h.nan.model.exception.parameter.ParameterException;
import com.web2h.nan.model.request.RequestParameters;

/**
 * Authentication service implementation class.
 * 
 * @author web2h
 */
@Service("authenticationService")
public class AuthenticationServiceImpl implements AuthenticationService {

	@Override
	public void authenticateRequest(RequestParameters parameters) throws ParameterException {
		if (parameters.getSignature() == null) {
			throw new MissingParameterException(RequestParameters.REQUEST_PARAM_SIGNATURE);
		}
		
		if (parameters.getTimestamp() == null) {
			throw new MissingParameterException(RequestParameters.REQUEST_PARAM_TIMESTAMP);
		}
		
		if (parameters.getTimestamp() == -1l) {
			throw new InvalidParameterException(RequestParameters.REQUEST_PARAM_TIMESTAMP);
		}
		
		if (parameters.getUserId() == null) {
			throw new MissingParameterException(RequestParameters.REQUEST_PARAM_USER_ID);
		}
		
		if (parameters.getUserId() == -1l) {
			throw new InvalidParameterException(RequestParameters.REQUEST_PARAM_USER_ID);
		}
	}
}