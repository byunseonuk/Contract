package com.exam.test.model;

public class SimpleApplicantVO {
	private int apply_id;
	private int user_id;
	private int resume_id;
	private String user_name;
	private String educationState;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getResume_id() {
		return resume_id;
	}
	public void setResume_no(int resume_id) {
		this.resume_id = resume_id;
	}
	public String getEducationState() {
		return educationState;
	}
	public void setEducationState(String educationState) {
		this.educationState = educationState;
	}
	public int getApply_id() {
		return apply_id;
	}
	public void setApply_id(int apply_id) {
		this.apply_id = apply_id;
	}
	@Override
	public String toString() {
		return "SimpleApplicantVO [apply_id=" + apply_id + ", user_id=" + user_id + ", resume_id=" + resume_id
				+ ", user_name=" + user_name + ", educationState=" + educationState + "]";
	}
	
	
}
