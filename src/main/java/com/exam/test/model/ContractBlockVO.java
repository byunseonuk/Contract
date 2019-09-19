package com.exam.test.model;

public class ContractBlockVO {
	private int contract_id;
	private String transactionHash;
	private String blockHash;
	private String blockNumber;
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
	public String getBlockHash() {
		return blockHash;
	}
	public void setBlockHash(String blockHash) {
		this.blockHash = blockHash;
	}
	public String getBlockNumber() {
		return blockNumber;
	}
	public void setBlockNumber(String blockNumber) {
		this.blockNumber = blockNumber;
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
		return "ContractBlockVO [contract_id=" + contract_id + ", transactionHash=" + transactionHash + ", blockHash="
				+ blockHash + ", blockNumber=" + blockNumber + ", confirmEE=" + confirmEE + ", confirmER=" + confirmER
				+ "]";
	}
	
}
