package com.web2h.nan.model.request;

/**
 * POJO containing common request parameters.
 * 
 * @author web2h
 */
public class RequestParameters {
	
	public static final String REQUEST_PARAM_SIGNATURE = "signature";
	public static final String REQUEST_PARAM_TIMESTAMP = "timestamp";
	public static final String REQUEST_PARAM_USER_ID = "userId";
	
	/** Request signature. */
	private String signature;
	
	/** Request time stamp. */
	private Long timestamp;
	
	/** User ID. */
	private Long userId;	
	
	/**
	 * Constructors with string parameters values extracted form the HTTP request.
	 * 
	 * @param signature The request signature
	 * @param timestamp The request time stamp
	 * @param userId The user ID
	 */
	public RequestParameters(String signature, String timestamp, String userId) {
		this.signature = signature;
		try {
			if (timestamp != null) {
				this.timestamp = Long.valueOf(timestamp);
			}
		} catch (NumberFormatException nfe) {
			this.timestamp = -1l;
		}
		try {
			if (userId != null) {
				this.userId = Long.valueOf(userId);
			}
		} catch (NumberFormatException nfe) {
			this.userId = -1l;
		}
	}
	
	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}	
}