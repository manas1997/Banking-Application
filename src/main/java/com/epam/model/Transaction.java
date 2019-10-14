/**
 * 
 */
package main.java.com.epam.model;

import main.java.com.epam.enums.TransactionType;

/**
 * @author Manas
 *
 */
public class Transaction {
	long id;
    public long getId() {
		return id;
	}

	TransactionType type;
    long accountNumber;
    double amount;

    /**
     * Instantiates a new transaction.
     *
     * @param type          the type
     * @param accountNumber the account number
     */
    public Transaction(TransactionType type, long accountNumber, double amount,long id) {
        this.type = type;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.id = id;
    }

    /**
     * Gets the type.
     *
     * @return the type
     */
    public TransactionType getType() {
        return type;
    }

    /**
     * Sets the type.
     *
     * @param type the new type
     */
    public void setType(TransactionType type) {
        this.type = type;
    }

    /**
     * Gets the account number.
     *
     * @return the account number
     */
    public long getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets the account number.
     *
     * @param accountNumber the new account number
     */
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * Gets the amount.
     *
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Sets the amount.
     *
     * @param amount the new amount
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }
}
