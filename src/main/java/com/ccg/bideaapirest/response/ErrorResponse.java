package com.ccg.bideaapirest.response;

public class ErrorResponse {
	private int statusCode;
	private String error;
	private String message;
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ErrorResponse [statusCode=");
		builder.append(statusCode);
		builder.append("error=");
		builder.append(error);
		builder.append("message=");
		builder.append(message);
		builder.append("]");
		return builder.toString();
		
	}
	
}
