package com.exam.test.model;

import java.util.Date;

public class ApplicantVO {
	private int _id;
	private int user_id;
	private int recruit_id;
	private int resume_id;
	private Date createdAt;
	private String state;
/*	wait - 지원완료, 대기중
	selected - 선택됨, 합격
	completed - 계약완료 */
	public int getUser_id() {
		return user_id;
	}
	public void setUser_no(int user_id) {
		this.user_id = user_id;
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
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "ApplicantVO [_id=" + _id + ", user_id=" + user_id + ", recruit_id=" + recruit_id + ", resume_id="
				+ resume_id + ", createdAt=" + createdAt + ", state=" + state + "]";
	}
	
}
