package com.example.geektrust.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.geektrust.beans.ExtraLoanPayment;
import com.example.geektrust.beans.Loan;
import com.example.geektrust.exceptions.BankingException;

public class BankLoansDaoImpl implements BankLoansDao {

	HashMap<String, Loan> loans = new HashMap<>();
	HashMap<String, ArrayList<ExtraLoanPayment>> extraPaymentSchedule = new HashMap<>();

	@Override
	public Loan getLoanByBankAndBorrowerName(String bankName, String borrowerName) throws BankingException {
		return loans.getOrDefault(getLoanIdentifier(bankName, borrowerName), null);
	}

	@Override
	public void addLoan(Loan newLoan) throws BankingException {
		String bankAndBorrowerName = getLoanIdentifier(newLoan.getBankName(), newLoan.getBorrowerName());
		if (!loans.containsKey(bankAndBorrowerName)) {
			loans.put(bankAndBorrowerName, newLoan);
			return;
		}
		throw new BankingException("400", "Loan already exists");
	}

	@Override
	public void updateLoan(Loan loan) throws BankingException {
		String bankAndBorrowerName = getLoanIdentifier(loan.getBankName(), loan.getBorrowerName());
		if (loans.containsKey(bankAndBorrowerName)) {
			loans.put(bankAndBorrowerName, loan);
			return;
		}
		throw new BankingException("400", "Loan to be updated doesn't exist");
	}

	private String getLoanIdentifier(String bankName, String borrowerName) {
		return bankName + "_" + borrowerName;
	}

	@Override
	public HashMap<String, ArrayList<ExtraLoanPayment>> getExtraPayment() throws BankingException {
		return extraPaymentSchedule;
	}
	
	@Override
	public void addExtraPayment(String loanId, ExtraLoanPayment pay) {
		if(extraPaymentSchedule.containsKey(loanId)) {
			ArrayList<ExtraLoanPayment> extraPayments = extraPaymentSchedule.get(loanId);
			extraPayments.add(pay);
		}else {
			ArrayList<ExtraLoanPayment> extraPayments = new ArrayList<>();
			extraPayments.add(pay);
			extraPaymentSchedule.put(loanId, extraPayments);
		}
	}

}
