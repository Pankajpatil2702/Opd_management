package com.opd_management.exception;

public class ErrorResponce {
	
	
	private int stetus;
	private String message;
	private long timestamp;
	
	
	
	
	public ErrorResponce(int stetus, String message) {
		super();
		this.stetus = stetus;
		this.message = message;
		this.timestamp = System.currentTimeMillis();
	}
	public int getStetus() {
		return stetus;
	}
	public void setStetus(int stetus) {
		this.stetus = stetus;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	

}
