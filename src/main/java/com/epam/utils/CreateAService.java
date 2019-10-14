package main.java.com.epam.utils;

import java.io.IOException;

import main.java.com.epam.service.AccountService;
import main.java.com.epam.service.TransactionService;
import main.java.com.epam.service.UserService;

public class CreateAService {
	private static CreateAService instance=null;
	UserService userService;
	AccountService accService;
	TransactionService trService;
	public UserService getUserService() {
		return userService;
	}
	public AccountService getAccService() {
		return accService;
	}
	public TransactionService getTransactionService() {
		return trService;
	}
	private CreateAService() throws IOException {
		userService = new UserService();
		accService = new AccountService();
		trService = new TransactionService();
	}
	public static CreateAService getInstance() throws IOException {
		if (instance==null) {
			instance = new CreateAService();
			System.out.println("in");
		}
		System.out.println("error");
		return instance;
	}
}
