package com.exam.test.model;

public class RecruitThumbVO {
	private int _id;
	private String company;
	private String title;
	private String endDate;
	private String workTime;
	private String workType;
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getWorkTime() {
		return workTime;
	}
	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}
	public String getWorkType() {
		return workType;
	}
	public void setWorkType(String workType) {
		this.workType = workType;
	}
	@Override
	public String toString() {
		return "RecruitThumbVO [company=" + company + ", title=" + title + ", endDate=" + endDate + ", workTime="
				+ workTime + ", workType=" + workType + "]";
	}

	
}
