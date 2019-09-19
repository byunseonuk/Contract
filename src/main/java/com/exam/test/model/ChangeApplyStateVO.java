package com.exam.test.model;

public class ChangeApplyStateVO {
	private int apply_id;
	private String state;
	private int contract_id;
	
	public int getApply_id() {
		return apply_id;
	}
	public void setApply_id(int apply_id) {
		this.apply_id = apply_id;
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
		return "ChangeApplyStateVO [apply_id=" + apply_id + ", state=" + state + ", contract_id=" + contract_id + "]";
	}
	
}
