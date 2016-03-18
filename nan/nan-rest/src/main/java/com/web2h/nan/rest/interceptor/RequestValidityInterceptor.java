package com.web2h.nan.rest.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.web2h.nan.core.service.AuthenticationService;
import com.web2h.nan.model.exception.parameter.ParameterException;
import com.web2h.nan.model.request.RequestParameters;

/**
 * Intercepter for all requests to check that the request is actually sent by the right user and that is not sent more than once.
 * 
 * @author web2h
 */
public class RequestValidityInterceptor implements HandlerInterceptor {
	
	/** Authentication service. */
	private AuthenticationService authenticationService;
	
	/**
	 * Constructor that initializes the authentication service attribute.
	 * 
	 * @param authenticationService
	 */
	public RequestValidityInterceptor(AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		RequestParameters parameters = new RequestParameters(request.getParameter(RequestParameters.REQUEST_PARAM_SIGNATURE), request.getParameter(RequestParameters.REQUEST_PARAM_TIMESTAMP), request.getParameter(RequestParameters.REQUEST_PARAM_USER_ID));
		
		try {
			authenticationService.authenticateRequest(parameters);
		} catch (ParameterException pe) {
			// TODO Log exception
			response.sendError(HttpStatus.UNAUTHORIZED.value(), pe.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception exception) throws Exception {		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView modelAndView) throws Exception {
	}
}