package com.exam.test.model;

import java.util.List;

public class CertificateVO {
	private int _id;
	private int resume_id;
	private String name;
	private String publisher;
	private String date;
	private List<CertificateVO> certificateList;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public List<CertificateVO> getCertificateList() {
		return certificateList;
	}
	public void setCertificateList(List<CertificateVO> certificateList) {
		this.certificateList = certificateList;
	}
	public int getResume_id() {
		return resume_id;
	}
	public void setResume_id(int resume_id) {
		this.resume_id = resume_id;
	}
	@Override
	public String toString() {
		return "CertificateVO [_id=" + _id + ", resume_id=" + resume_id + ", name=" + name + ", publisher=" + publisher
				+ ", date=" + date + ", certificateList=" + certificateList + "]";
	}
	
	
}
