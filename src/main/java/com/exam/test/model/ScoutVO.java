package com.exam.test.model;

import java.util.Date;

public class ScoutVO {
	private int user_id;
	private int recruit_id;
	private Date createdAt;
	public int getUser_no() {
		return user_id;
	}
	public void setUser_no(int user_id) {
		this.user_id = user_id;
	}
	public int getRecruit_id() {
		return recruit_id;
	}
	public void setRecruit_no(int recruit_id) {
		this.recruit_id = recruit_id;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	@Override
	public String toString() {
		return "ScoutVO [user_no=" + user_id + ", recruit_no=" + recruit_id + ", createdAt=" + createdAt + "]";
	}
	
}
