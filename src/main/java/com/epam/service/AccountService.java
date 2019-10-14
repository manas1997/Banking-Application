/**
 * 
 */
package main.java.com.epam.service;
import java.io.IOException;
import main.java.com.epam.dao.Dao;
import main.java.com.epam.dao.DaoImplementationAccount;
import main.java.com.epam.enums.AccountStatus;
import main.java.com.epam.enums.AccountType;
import main.java.com.epam.model.Account;



/**
 * The Class AccountService.
 *
 * @author Manas
 */
public class AccountService implements Services<Account> {
	
	/**
	 * Instantiates a new account service.
	 */
	public AccountService() {
		daoObject=new DaoImplementationAccount();
	}
	
	/** The dao object. */
	static Dao<Account> daoObject;

	/**
	 * Gets the dao.
	 *
	 * @return the dao
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static Dao<Account> getDao() throws IOException {
		return daoObject;
	}
	
	/** The new created account status. */
	AccountStatus newCreatedAccountStatus;
	
	/**
	 * creates an account
	 * @param arguments needed to create an object
	 * @return status of create
	 */
	@Override
    public boolean create(String[] args) {
        Account newCreatedAccount = new Account(args);
        System.out.println(newCreatedAccount.getAccountNumber());
        newCreatedAccount.setAccountStatus(AccountStatus.ACTIVE);
        newCreatedAccountStatus = newCreatedAccount.getAccountStatus();
        return daoObject.save(newCreatedAccount);
        }
	/**
	 * Delete the account
	 *
	 * @param t the t
	 * @return true, if successful
	 */
	@Override
    public boolean delete(Account t) {
    	t.setAccountStatus(AccountStatus.INACTIVE);
        return daoObject.delete(t);
    }

	/**
	 * Update the account
	 *
	 * @param t the t
	 * @param args the args
	 * @return true, if successful
	 */
	@Override
    public boolean update(Account t, String[] args) {
    	t.setBalance(Double.parseDouble(args[0]));
    	t.setAccountType(AccountType.valueOf(args[1]));
        daoObject.update(t, args);
        return true;
    }
	/**
	 * Gets the details.
	 *
	 * @param t the t
	 * @return the details
	 */
    @Override
    public Account getDetails(long t) {
        return (Account) daoObject.get(t).get();
    }
    
    /**
     * Gets the account status.
     *
     * @return the account status
     */
    public AccountStatus getAccountStatus() {
    	return newCreatedAccountStatus;
    }
}
