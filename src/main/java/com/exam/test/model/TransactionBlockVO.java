package com.exam.test.model;

public class TransactionBlockVO {
	private int contract_id;
	private String transactionHash;
	private boolean recordBlock;
	private boolean confirmEE;
	private boolean confirmER;
	
	public int getContract_id() {
		return contract_id;
	}
	public void setContract_id(int contract_id) {
		this.contract_id = contract_id;
	}
	public String getTransactionHash() {
		return transactionHash;
	}
	public void setTransactionHash(String transactionHash) {
		this.transactionHash = transactionHash;
	}
	public boolean isRecordBlock() {
		return recordBlock;
	}
	public void setRecordBlock(boolean recordBlock) {
		this.recordBlock = recordBlock;
	}
	public boolean isConfirmEE() {
		return confirmEE;
	}
	public void setConfirmEE(boolean confirmEE) {
		this.confirmEE = confirmEE;
	}
	public boolean isConfirmER() {
		return confirmER;
	}
	public void setConfirmER(boolean confirmER) {
		this.confirmER = confirmER;
	}
	@Override
	public String toString() {
		return "TransactionBlockVO [contract_id=" + contract_id + ", transactionHash=" + transactionHash
				+ ", recordBlock=" + recordBlock + ", confirmEE=" + confirmEE + ", confirmER=" + confirmER + "]";
	}
	
	
}
