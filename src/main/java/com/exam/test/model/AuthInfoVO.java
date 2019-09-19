package com.exam.test.model;

public class AuthInfoVO {
	private int _id;
	private String identifier;
	private String name;
	private String email;
	private String phone;
	private String role;
	
	public AuthInfoVO() {
		
	}

	public AuthInfoVO(int _id, String identifier, String name, String email, String phone, String role) {
		super();
		this._id = _id;
		this.identifier = identifier;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.role = role;
	}
	
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "AuthInfoVO [_id=" + _id + ", identifier=" + identifier + ", name=" + name + ", email=" + email
				+ ", phone=" + phone + ", role=" + role + "]";
	}
	
	
}
