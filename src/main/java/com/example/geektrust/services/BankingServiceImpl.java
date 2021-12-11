package com.example.geektrust.services;

import java.util.ArrayList;

import com.example.geektrust.beans.ExtraLoanPayment;
import com.example.geektrust.beans.Loan;
import com.example.geektrust.dao.BankLoansDao;
import com.example.geektrust.dao.BankLoansDaoImpl;
import com.example.geektrust.exceptions.BankingException;

public class BankingServiceImpl implements BankingService {

	BankLoansDao dao = new BankLoansDaoImpl();

	@Override
	public void takeLoan(String bankName, String borrowerName, int principal, int term, int rateOfInterest)
			throws BankingException {
		if (principal < 0 || term < 0 || rateOfInterest < 0) {
			throw new BankingException("Negative values of Principal, Term Period or Rate of Interests not allowed");
		}

		int interest = (int) Math.ceil(term* rateOfInterest * principal/100);
		int totalAmount = principal + interest;
		int emiAmount = (int) Math.ceil(totalAmount / (term * 12));
		int numOfEmis = (int) Math.ceil(totalAmount / emiAmount);

		Loan l = new Loan(bankName, borrowerName, totalAmount, 0, emiAmount, numOfEmis);
		dao.addLoan(l);
	}

	@Override
	public void doPayment(String bankName, String borrowerName, int lumpSum, int emiNum) throws BankingException {

		Loan l = dao.getLoanByBankAndBorrowerName(bankName, borrowerName);
		String loanId = l.getBankName()+"_"+l.getBorrowerName();
		
		ExtraLoanPayment extraPay = new ExtraLoanPayment();
		extraPay.setAfterEmiNum(emiNum);
		extraPay.setLumpSum(lumpSum);
		dao.addExtraPayment(loanId, extraPay);
//		int paidAmount = l.getPaidAmount();
//		paidAmount += lumpSum;
//
//		if (paidAmount > l.getTotalAmount()) {
//			throw new BankingException("Paying unnecessary surplus amount");
//			// in case that's allowed, we'd modify this condition just to mark loan repayed
//			// by deleting it from dao
//		}
//
//		// l.setNumOfEmisLeft((int) Math.ceil(predictedRemainingAmount / l.getEmiAmount()));
//		l.setNumOfEmisLeft(l.getNumOfEmisLeft()-lumpSum/l.getEmiAmount());
//		l.setPaidAmount(paidAmount);
//
//		dao.updateLoan(l);
	}

	@Override
	public String getBalanceDetails(String bankName, String borrowerName, int emiNum) throws BankingException {

		Loan l = dao.getLoanByBankAndBorrowerName(bankName, borrowerName);
		String loanId = l.getBankName()+"_"+l.getBorrowerName();
		
		int extraPay = 0;
		
		// add all extraPay of emiNum less than currEmiNum
		if(dao.getExtraPayment().containsKey(loanId)) {
			ArrayList<ExtraLoanPayment> pays = dao.getExtraPayment().get(loanId);
			for(ExtraLoanPayment pay: pays) {
				if(pay.getAfterEmiNum()<emiNum) {
					extraPay += pay.getLumpSum();
				}
			}
		}
		String outputString = String.format(bankName + " " + borrowerName + " "
				//+"total "+ l.getTotalAmount() + " emiAmt " + l.getEmiAmount() + " emileft: "+l.getNumOfEmisLeft() +" remaining: "+l.getRemainingAmount()+" paid: " +
				+ (emiNum*l.getEmiAmount() + extraPay) + " " + (l.getNumOfEmisLeft()-emiNum-(extraPay/l.getEmiAmount())));
		return outputString;
	}

}
