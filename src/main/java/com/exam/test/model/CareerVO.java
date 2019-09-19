package com.exam.test.model;

import java.util.List;

public class CareerVO {
	private int _id;
	private int resume_id;
	private String startDate;
	private String endDate;
	private String companyName;
	private String position;
	private String work;
	private List<CareerVO> careerList;
	
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
	}
	public List<CareerVO> getCareerList() {
		return careerList;
	}
	public void setCareerList(List<CareerVO> careerList) {
		this.careerList = careerList;
	}
	public int getResume_id() {
		return resume_id;
	}
	public void setResume_id(int resume_id) {
		this.resume_id = resume_id;
	}
	@Override
	public String toString() {
		return "CareerVO [_id=" + _id + ", resume_id=" + resume_id + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", companyName=" + companyName + ", position=" + position + ", work=" + work + ", careerList="
				+ careerList + "]";
	}

	
	
	
}
