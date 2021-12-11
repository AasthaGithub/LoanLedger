package com.example.geektrust.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.geektrust.beans.ExtraLoanPayment;
import com.example.geektrust.beans.Loan;
import com.example.geektrust.exceptions.BankingException;

public interface BankLoansDao {

	public Loan getLoanByBankAndBorrowerName(String bankName, String borrowerName) throws BankingException;

	public void addLoan(Loan loan) throws BankingException;

	public void updateLoan(Loan loan) throws BankingException;
	
	public HashMap<String, ArrayList<ExtraLoanPayment>> getExtraPayment() throws BankingException;

	void addExtraPayment(String loanId, ExtraLoanPayment pay);

}
