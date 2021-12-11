package com.example.geektrust.beans;

public class ExtraLoanPayment {

	int lumpSum;
	int afterEmiNum;
	
	public ExtraLoanPayment() {
		super();
	}
	
	public ExtraLoanPayment(int lumpSum, int afterEmiNum) {
		super();
		this.lumpSum = lumpSum;
		this.afterEmiNum = afterEmiNum;
	}
	
	public int getLumpSum() {
		return lumpSum;
	}
	public void setLumpSum(int lumpSum) {
		this.lumpSum = lumpSum;
	}
	public int getAfterEmiNum() {
		return afterEmiNum;
	}
	public void setAfterEmiNum(int afterEmiNum) {
		this.afterEmiNum = afterEmiNum;
	}
	
	
}
