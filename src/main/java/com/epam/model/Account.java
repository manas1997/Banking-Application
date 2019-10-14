/**
 * 
 */
package main.java.com.epam.model;

import main.java.com.epam.constants.Constant;
import main.java.com.epam.enums.AccountStatus;
import main.java.com.epam.enums.AccountType;
import main.java.com.epam.utils.GenerateAccountNumber;

/**
 * The Class Account.
 *
 * @author Manas
 */
public class Account {
	protected AccountStatus accountStatus;
    protected AccountType accountType;
    protected final long accountNumber;
    protected double balance;

    /**
     * Instantiates a new account.
     *
     * @param argumentsToCreateAccount the arguments to create account
     */
    public Account(String[] argumentsToCreateAccount) {
        accountNumber = setAccountNumber();
        this.balance = Double.parseDouble(argumentsToCreateAccount[Constant.ARGUMENT_FOR_ACCOUNT_BALANCE]);
        this.accountType = AccountType.valueOf(argumentsToCreateAccount[Constant.ARGUMENT_FOR_ACCOUNT_TYPE]);
    }

    /**
     * Sets the account number.
     *
     * @return the account number
     */
    private long setAccountNumber() {
        return  new GenerateAccountNumber().getGeneratedAccountNumber();
    }

    /**
     * Gets the account number.
     *
     * @return account number
     */
    public long getAccountNumber() {

        return this.accountNumber;
    }

    /**
     * Gets the balance.
     *
     * @return the balance
     */
    public double getBalance() {

        return this.balance;
    }

    /**
     * Sets the balance.
     *
     * @param balance the new balance
     */
    public void setBalance(double balance) {

        this.balance = balance;
    }

    /**
     * Gets the account type.
     *
     * @return account type
     */
    public AccountType getAccountType() {
        return accountType;
    }

    /**
     * Sets the account type.
     *
     * @param accountType the new account type
     */
    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

	/**
	 * Gets the account status.
	 *
	 * @return the accountStatus
	 */
	public AccountStatus getAccountStatus() {
		return accountStatus;
	}

	/**
	 * @param accountStatus the accountStatus to set
	 */
	public void setAccountStatus(AccountStatus accountStatus) {
		this.accountStatus = accountStatus;
	}

}
