package com.exam.test.model;

import java.util.List;

public class LanguageVO {
	private int _id;
	private int resume_id;
	private String kinds;
	private String score;
	private String date;
	private List<LanguageVO> languageList;
	
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public String getKinds() {
		return kinds;
	}
	public void setKinds(String kinds) {
		this.kinds = kinds;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public List<LanguageVO> getLanguageList() {
		return languageList;
	}
	public void setLanguageList(List<LanguageVO> languageList) {
		this.languageList = languageList;
	}
	public int getResume_id() {
		return resume_id;
	}
	public void setResume_id(int resume_id) {
		this.resume_id = resume_id;
	}
	@Override
	public String toString() {
		return "LanguageVO [_id=" + _id + ", resume_id=" + resume_id + ", kinds=" + kinds + ", score=" + score
				+ ", date=" + date + ", languageList=" + languageList + "]";
	}
	
}
