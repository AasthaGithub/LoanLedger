package com.example.geektrust.services;

import com.example.geektrust.exceptions.BankingException;

public interface BankingService {

	// LOAN BANK_NAME BORROWER_NAME PRINCIPAL NO_OF_YEARS RATE_OF_INTEREST
	public void takeLoan(String bankName, String borrowerName, int principal, int term, int interest)
			throws BankingException;

	// PAYMENT BANK_NAME BORROWER_NAME LUMP_SUM_AMOUNT EMI_NO
	public void doPayment(String bankName, String borrowerName, int lumpSum, int emiNum) throws BankingException;

	// BALANCE BANK_NAME BORROWER_NAME EMI_NO
	public String getBalanceDetails(String bankName, String borrowerName, int emiNum) throws BankingException;
}
