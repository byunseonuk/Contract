package com.exam.test.model;

public class ResumeVO {
	private int _id;
	private int user_id;
	private String title;
	private String graduationDate;
	private String admissionDate;
	private String educationState;
	private String schoolName;
	private String major;
	private String selfIntroduction;
//	title �߰� 
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGraduationDate() {
		return graduationDate;
	}
	public void setGraduationDate(String graduationDate) {
		this.graduationDate = graduationDate;
	}
	public String getAdmissionDate() {
		return admissionDate;
	}
	public void setAdmissionDate(String admissionDate) {
		this.admissionDate = admissionDate;
	}
	public String getEducationState() {
		return educationState;
	}
	public void setEducationState(String educationState) {
		this.educationState = educationState;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getSelfIntroduction() {
		return selfIntroduction;
	}
	public void setSelfIntroduction(String selfIntroduction) {
		this.selfIntroduction = selfIntroduction;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	@Override
	public String toString() {
		return "ResumeVO [_id=" + _id + ", user_id=" + user_id + ", title=" + title + ", graduationDate="
				+ graduationDate + ", admissionDate=" + admissionDate + ", educationState=" + educationState
				+ ", schoolName=" + schoolName + ", major=" + major + ", selfIntroduction=" + selfIntroduction + "]";
	}
	
	
	
}

