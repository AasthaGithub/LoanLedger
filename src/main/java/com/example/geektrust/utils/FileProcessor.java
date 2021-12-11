package com.example.geektrust.utils;

import static com.example.geektrust.PropertyConstants.Commands.BALANCE;
import static com.example.geektrust.PropertyConstants.Commands.INVALID_COMMAND;
import static com.example.geektrust.PropertyConstants.Commands.LOAN;
import static com.example.geektrust.PropertyConstants.Commands.PAYMENT;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.example.geektrust.exceptions.BankingException;
import com.example.geektrust.services.BankingService;

public class FileProcessor {

	public static void processInputFile(BankingService bankingService, File file) throws BankingException {
		try (Scanner sc = new Scanner(file)) {
			while (sc.hasNextLine()) {
				String command = sc.nextLine();
				processInputCommand(bankingService, command);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found!! Please check the file and the location provided!");
		}

	}

	private static void processInputCommand(BankingService bankingService, String command) throws BankingException {
		String[] commandParams = command.split(" ");
		String commandResult = null;
		switch (commandParams[0]) {
		case LOAN:
			bankingService.takeLoan(commandParams[1], commandParams[2], Integer.parseInt(commandParams[3]),
					Integer.parseInt(commandParams[4]), Integer.parseInt(commandParams[5]));
			break;

		case PAYMENT:
			bankingService.doPayment(commandParams[1], commandParams[2], Integer.parseInt(commandParams[3]),
					Integer.parseInt(commandParams[4]));
			break;

		case BALANCE:
			commandResult = bankingService.getBalanceDetails(commandParams[1], commandParams[2],
					Integer.parseInt(commandParams[3]));
			break;
		default:
			commandResult = INVALID_COMMAND;
			break;
		}

		System.out.println(commandResult);

	}
}
