package com.opd_management.responce;

import java.time.LocalDateTime;

public class ErrorResponse {
	
	private int status; // HttpStetusCode
	private String message;   // exception message
	private LocalDateTime timestamp;
	
	
	
	public ErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ErrorResponse(int status, String message, LocalDateTime timestamp) {
		super();
		this.status = status;
		this.message = message;
		this.timestamp = timestamp;
	}
	
//	public ErrorResponse(int status, String message ) {
//		super();
//		this.status = status;
//		this.message = message;
//		this.timestamp = LocalDateTime.now();
//	}
	
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	} 
	
	
	
	

}
