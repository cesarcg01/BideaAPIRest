package com.ccg.bideaapirest.response;

public class BookResponse {
	private int code;
	private String message;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BookResponse [code=");
		builder.append(code);
		builder.append("message=");
		builder.append(message);
		builder.append("]");
		return builder.toString();
		
	}
}
