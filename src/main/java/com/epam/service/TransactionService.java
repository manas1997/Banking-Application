/**
 * 
 */
package main.java.com.epam.service;

import java.io.IOException;

import main.java.com.epam.dao.Dao;
import main.java.com.epam.dao.DaoImplementationAccount;
import main.java.com.epam.dao.DaoImplementationTransaction;
import main.java.com.epam.enums.TransactionType;
import main.java.com.epam.exceptions.IllegalAmountException;
import main.java.com.epam.exceptions.InsufficientAmountException;
import main.java.com.epam.model.Account;
import main.java.com.epam.model.Transaction;

/**
 * The Class TransactionService.
 *
 * @author Manas
 */
public class TransactionService implements Services<Transaction>{
	
	/** The dao transaction object. */
	static Dao<Transaction> daoTransactionObject;
	
	/** The dao account object. */
	static Dao<Account> daoAccountObject;

	/**
	 * Instantiates a new transaction service.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public TransactionService() throws IOException {
			daoAccountObject = new DaoImplementationAccount();
			daoTransactionObject= new DaoImplementationTransaction();
	}
	
	/**
	 * Gets the dao transaction.
	 *
	 * @return the dao transaction
	 */
	public static Dao<Transaction> getDaoTransaction(){
		return daoTransactionObject;
	}
	
	/**
	 * Gets the dao account.
	 *
	 * @return the dao account
	 */
	public static Dao<Account> getDaoAccount(){
		return daoAccountObject;
	}
	
	/**
	 * creates a transaction
	 * @param arguments needed to create an object
	 * @return true, if successful
	 */
	@Override
    public boolean create(String[] args) {
        Transaction newTransaction = new Transaction(TransactionType.valueOf(args[0]), Long.parseLong(args[1]),Double.parseDouble(args[2]),Long.parseLong(args[3]));
        return daoTransactionObject.save(newTransaction);
    }

	/**
	 * deletes a transaction
	 * @param transaction object
	 * @return true, if successful
	 */
	@Override
    public boolean delete(Transaction t) {
        return daoTransactionObject.delete(t);
    }

	/**
	 * updates a transaction
	 * @param transaction object
	 * @param arguments needed to update an object
	 * @return true, if successful
	 */
	@Override
    public boolean update(Transaction t, String[] args) {
    	t.setType(TransactionType.valueOf(args[0]));
    	t.setAccountNumber(Integer.parseInt(args[1]));
    	t.setAmount(Double.parseDouble(args[2]));
        return daoTransactionObject.update(t, args);
    }
	
	/**
	 * get details of a transaction
	 * @param transaction number
	 * @return transaction object
	 */
    @Override
    public Transaction getDetails(long t) {
        return (Transaction) daoTransactionObject.get(t).get();
    }
	
	/**
	 * Deposit.
	 *
	 * @param account the account
	 * @param amountToBeDeposited the amount to be deposited
	 * @param transactionNumber the i
	 * @return current balance
	 * @throws IllegalAmountException the illegal amount exception
	 */
	public double deposit(Account account, double amountToBeDeposited,long transactionNumber) throws IllegalAmountException {
        double currentBalance = account.getBalance();
        if (amountToBeDeposited <= 0.0) {
            throw new IllegalAmountException();
        }
        currentBalance += amountToBeDeposited;
        account.setBalance(currentBalance);
        String[] balanceUpdate = {"balance"};
        daoAccountObject.update(account,balanceUpdate);
        String[] argument = { TransactionType.DEPOSIT.toString(),Long.toString(account.getAccountNumber()),Double.toString(amountToBeDeposited),Long.toString(transactionNumber)};
        create(argument);
        return currentBalance;
    }
	
	/**
	 * Withdraw.
	 *
	 * @param account the account
	 * @param amountToWithdraw the amount to withdraw
	 * @param transactionNumber the i
	 * @return current balance
	 * @throws IllegalAmountException the illegal amount exception
	 * @throws InsufficientAmountException the insufficient amount exception
	 */
	public double withdraw(Account account, double amountToWithdraw,long transactionNumber)
            throws IllegalAmountException, InsufficientAmountException {
        double currentBalance = account.getBalance();
        if (amountToWithdraw <= 0.0) {
            throw new IllegalAmountException();
        } else if (amountToWithdraw > currentBalance) {
            throw new InsufficientAmountException();
        }
        currentBalance -= amountToWithdraw;
        account.setBalance(currentBalance);
        String[] balanceUpdate = {"balance"};
        daoAccountObject.update(account,balanceUpdate);
        String[] argument = { TransactionType.WITHDRAW.toString(),Long.toString(account.getAccountNumber()),Double.toString(amountToWithdraw),Long.toString(transactionNumber) };
        create(argument);
        return currentBalance;
    }
    

}
