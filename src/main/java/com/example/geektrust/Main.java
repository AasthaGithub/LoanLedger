package com.example.geektrust;

import java.io.File;

import com.example.geektrust.exceptions.BankingException;
import com.example.geektrust.services.BankingService;
import com.example.geektrust.services.BankingServiceImpl;
import com.example.geektrust.utils.FileProcessor;

public class Main {

	public void initFileToProcess(BankingService bankingService, String filePath) throws BankingException {
		File file = new File(filePath);
		FileProcessor.processInputFile(bankingService, file);
	}

	public static void main(String... args) {

		Main m = new Main();
		BankingService bankingService = new BankingServiceImpl();
		try {
			m.initFileToProcess(bankingService, args[0]);
		} catch (BankingException e) {
			System.out.print(e.getErrorCode() + e.getMessage() + e.getCause());
		}

	}
}
