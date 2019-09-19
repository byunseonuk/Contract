package com.exam.test.model;

import java.util.Date;

public class RecruitmentVO {
	private int _id;
	private Date createdAt;
	private Date updatedAt;
	private boolean isEnded;
	

	//등록자 정보 and 회사정보
	private String company;
	private String title;
	private String managerName;
	private String managerTel;
	private String managerEmail;
	private String companyTel;
	private String address;
	private int owner;
	
	//모집조건
	private String endDate;
	private String gender;
	private String preferential;
	private String education;
	private int personnel;
	private int age;
	
	//근무조건
	private int salary;
	private String salaryType;
	private String workPeriod;
	private String workDay;
	private String workTime;
	private String workType;
	
	public int get_id() {
		return _id; 
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public boolean getIsEnded() {
		return isEnded;
	}
	public void setIsEnded(boolean isEnded) {
		this.isEnded = isEnded;
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
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getManagerTel() {
		return managerTel;
	}
	public void setManagerTel(String managerTel) {
		this.managerTel = managerTel;
	}
	public String getManagerEmail() {
		return managerEmail;
	}
	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}
	public String getCompanyTel() {
		return companyTel;
	}
	public void setCompanyTel(String companyTel) {
		this.companyTel = companyTel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getOwner() {
		return owner;
	}
	public void setOwner(int owner) {
		this.owner = owner;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPreferential() {
		return preferential;
	}
	public void setPreferential(String preferential) {
		this.preferential = preferential;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public int getPersonnel() {
		return personnel;
	}
	public void setPersonnel(int personnel) {
		this.personnel = personnel;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getSalaryType() {
		return salaryType;
	}
	public void setSalaryType(String salaryType) {
		this.salaryType = salaryType;
	}
	public String getWorkPeriod() {
		return workPeriod;
	}
	public void setWorkPeriod(String workPeriod) {
		this.workPeriod = workPeriod;
	}
	public String getWorkDay() {
		return workDay;
	}
	public void setWorkDay(String workDay) {
		this.workDay = workDay;
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
		return "RecruitmentVO [_id=" + _id + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", isEnded="
				+ isEnded + ", company=" + company + ", title=" + title + ", managerName=" + managerName
				+ ", managerTel=" + managerTel + ", managerEmail=" + managerEmail + ", companyTel=" + companyTel
				+ ", address=" + address + ", owner=" + owner + ", endDate=" + endDate + ", gender=" + gender
				+ ", preferential=" + preferential + ", education=" + education + ", personnel=" + personnel + ", age="
				+ age + ", salary=" + salary + ", salaryType=" + salaryType + ", workPeriod=" + workPeriod
				+ ", workDay=" + workDay + ", workTime=" + workTime + ", workType=" + workType + "]";
	}
	
	
}
