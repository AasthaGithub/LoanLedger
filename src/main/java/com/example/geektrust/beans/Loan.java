package com.example.geektrust.beans;

import java.util.Objects;

public class Loan {

	private String bankName;
	private String borrowerName;

	private int totalAmount;
	private int paidAmount;

	private int emiAmount;
	private int numOfEmisLeft;

	public Loan() {
		super();
	}

	public Loan(String bankName, String borrowerName, int totalAmount, int remainingAmount, int emiAmount,
			int numOfEmisLeft) {
		super();
		this.bankName = bankName;
		this.borrowerName = borrowerName;
		this.totalAmount = totalAmount;
		this.paidAmount = remainingAmount;
		this.emiAmount = emiAmount;
		this.numOfEmisLeft = numOfEmisLeft;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBorrowerName() {
		return borrowerName;
	}

	public void setBorrowerName(String borrowerName) {
		this.borrowerName = borrowerName;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(int paidAmount) {
		this.paidAmount = paidAmount;
	}

	public int getEmiAmount() {
		return emiAmount;
	}

	public void setEmiAmount(int emiAmount) {
		this.emiAmount = emiAmount;
	}

	public int getNumOfEmisLeft() {
		return numOfEmisLeft;
	}

	public void setNumOfEmisLeft(int numOfEmisLeft) {
		this.numOfEmisLeft = numOfEmisLeft;
	}

	@Override
	public String toString() {
		return "Loan [bankName=" + bankName + ", borrowerName=" + borrowerName + ", totalAmount=" + totalAmount
				+ ", paidAmount=" + paidAmount + ", emiAmount=" + emiAmount + ", numOfEmisLeft="
				+ numOfEmisLeft + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(bankName, borrowerName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Loan other = (Loan) obj;
		return (bankName.equals(other.bankName)) && (borrowerName.equals(other.borrowerName));
	}

}
