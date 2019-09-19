package com.exam.test.model;

public class LoginVO {
	private String identifier;
	private String password;
	private boolean rememberID;
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isRememberID() {
		return rememberID;
	}
	public void setRememberID(boolean rememberID) {
		this.rememberID = rememberID;
	}
	
	
}
