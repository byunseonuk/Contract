package com.exam.test.model;

import java.util.Date;

public class ContractVO {
	
	private int _id;
	private int employer_id;
	private int employee_id;
	private String employer;
	private String employer_address;
	private String employer_tel;
	private String employee;
	private String employee_address;
	private String employee_tel;
	private String start_date;
	private String end_date;
	private String work_place;
	private String work_details;
	private String start_time;
	private String end_time;
	private String break_time;
	private String work_date;
	private String holiday;
	private String salary;
	private String bonus;
	private String other_benefits;
	private String payment_date;
	private String payment_method;
	private String insurance1;
	private String insurance2;
	private String insurance3;
	private String insurance4;
	private String other_contents;
	private String state;
	private Date contract_date;
	private boolean recordBlock;
	
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public int getEmployer_id() {
		return employer_id;
	}
	public void setEmployer_id(int employer_id) {
		this.employer_id = employer_id;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getEmployer() {
		return employer;
	}
	public void setEmployer(String employer) {
		this.employer = employer;
	}
	public String getEmployer_address() {
		return employer_address;
	}
	public void setEmployer_address(String employer_address) {
		this.employer_address = employer_address;
	}
	public String getEmployer_tel() {
		return employer_tel;
	}
	public void setEmployer_tel(String employer_tel) {
		this.employer_tel = employer_tel;
	}
	public String getEmployee() {
		return employee;
	}
	public void setEmployee(String employee) {
		this.employee = employee;
	}
	public String getEmployee_address() {
		return employee_address;
	}
	public void setEmployee_address(String employee_address) {
		this.employee_address = employee_address;
	}
	public String getEmployee_tel() {
		return employee_tel;
	}
	public void setEmployee_tel(String employee_tel) {
		this.employee_tel = employee_tel;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public String getWork_place() {
		return work_place;
	}
	public void setWork_place(String work_place) {
		this.work_place = work_place;
	}
	public String getWork_details() {
		return work_details;
	}
	public void setWork_details(String work_details) {
		this.work_details = work_details;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public String getBreak_time() {
		return break_time;
	}
	public void setBreak_time(String break_time) {
		this.break_time = break_time;
	}
	public String getWork_date() {
		return work_date;
	}
	public void setWork_date(String work_date) {
		this.work_date = work_date;
	}
	public String getHoliday() {
		return holiday;
	}
	public void setHoliday(String holiday) {
		this.holiday = holiday;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getBonus() {
		return bonus;
	}
	public void setBonus(String bonus) {
		this.bonus = bonus;
	}
	public String getOther_benefits() {
		return other_benefits;
	}
	public void setOther_benefits(String other_benefits) {
		this.other_benefits = other_benefits;
	}
	public String getPayment_date() {
		return payment_date;
	}
	public void setPayment_date(String payment_date) {
		this.payment_date = payment_date;
	}
	public String getPayment_method() {
		return payment_method;
	}
	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}
	public String getInsurance1() {
		return insurance1;
	}
	public void setInsurance1(String insurance1) {
		this.insurance1 = insurance1;
	}
	public String getInsurance2() {
		return insurance2;
	}
	public void setInsurance2(String insurance2) {
		this.insurance2 = insurance2;
	}
	public String getInsurance3() {
		return insurance3;
	}
	public void setInsurance3(String insurance3) {
		this.insurance3 = insurance3;
	}
	public String getInsurance4() {
		return insurance4;
	}
	public void setInsurance4(String insurance4) {
		this.insurance4 = insurance4;
	}
	public String getOther_contents() {
		return other_contents;
	}
	public void setOther_contents(String other_contents) {
		this.other_contents = other_contents;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getContract_date() {
		return contract_date;
	}
	public void setContract_date(Date contract_date) {
		this.contract_date = contract_date;
	}
	public boolean isRecordBlock() {
		return recordBlock;
	}
	public void setRecordBlock(boolean recordBlock) {
		this.recordBlock = recordBlock;
	}
	
	@Override
	public String toString() {
		return "ContractVO [_id=" + _id + ", employer_id=" + employer_id + ", employee_id=" + employee_id
				+ ", employer=" + employer + ", employer_address=" + employer_address + ", employer_tel=" + employer_tel
				+ ", employee=" + employee + ", employee_address=" + employee_address + ", employee_tel=" + employee_tel
				+ ", start_date=" + start_date + ", end_date=" + end_date + ", work_ploace=" + work_place
				+ ", work_details=" + work_details + ", start_time=" + start_time + ", end_time=" + end_time
				+ ", break_time=" + break_time + ", work_date=" + work_date + ", holiday=" + holiday + ", salary="
				+ salary + ", bonus=" + bonus + ", other_benefits=" + other_benefits + ", payment_date=" + payment_date
				+ ", payment_method=" + payment_method + ", insurance1=" + insurance1 + ", insurance2=" + insurance2
				+ ", insurance3=" + insurance3 + ", insurance4=" + insurance4 + ", other_contens=" + other_contents
				+ ", state=" + state + ", contract_date=" + contract_date + ", recordBlock=" + recordBlock + "]";
	}
	
	public String toJsonString() {
		return "{ \"employer\":\"" + employer + "\", \"employer_address\":\"" + employer_address + "\", \"employer_tel\":\"" + employer_tel
				+ "\", \"employee\":\"" + employee + "\", \"employee_address\":\"" + employee_address + "\", \"employee_tel\":\"" + employee_tel
				+ "\", \"start_date\":\"" + start_date + "\", \"end_date\":\"" + end_date + "\", \"work_place\":\"" + work_place
				+ "\", \"work_details\":\"" + work_details + "\", \"start_time\":\"" + start_time + "\", \"end_time\":\"" + end_time
				+ "\", \"break_time\":\"" + break_time + "\", \"work_date\":\"" + work_date + "\", \"holiday\":\"" + holiday + "\", \"salary\":\""
				+ salary + "\", \"bonus\":\"" + bonus + "\", \"other_benefits\":\"" + other_benefits + "\", \"payment_date\":\"" + payment_date
				+ "\", \"payment_method\":\"" + payment_method + "\", \"insurance1\":\"" + insurance1 + "\", \"insurance2\":\"" + insurance2
				+ "\", \"insurance3\":\"" + insurance3 + "\", \"insurance4\":\"" + insurance4 + "\", \"other_contents\":\"" + other_contents
				+ "\", \"contract_date\":\"" + contract_date + "\"}";
	}
}
