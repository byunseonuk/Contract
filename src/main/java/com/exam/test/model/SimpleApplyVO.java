package com.exam.test.model;

public class SimpleApplyVO {
	private String recruit_title;
	private String state;
	private int contract_id;
	private int recruit_id;
	private int resume_id;
	private String company;
	public String getRecruit_title() {
		return recruit_title;
	}
	public void setRecruit_title(String recruit_title) {
		this.recruit_title = recruit_title;
	}
	public int getRecruit_id() {
		return recruit_id;
	}
	public void setRecruit_id(int recruit_id) {
		this.recruit_id = recruit_id;
	}
	public int getResume_id() {
		return resume_id;
	}
	public void setResume_id(int resume_id) {
		this.resume_id = resume_id;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getContract_id() {
		return contract_id;
	}
	public void setContract_id(int contract_id) {
		this.contract_id = contract_id;
	}
	@Override
	public String toString() {
		return "SimpleApplyVO [recruit_title=" + recruit_title + ", state=" + state + ", contract_id=" + contract_id
				+ ", recruit_id=" + recruit_id + ", resume_id=" + resume_id + ", company=" + company + "]";
	}

	
	
}
