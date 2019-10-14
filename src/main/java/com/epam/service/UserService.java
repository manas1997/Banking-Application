/**
 * 
 */
package main.java.com.epam.service;

import java.io.IOException;

import main.java.com.epam.dao.Dao;
import main.java.com.epam.dao.DaoImplementationUser;
import main.java.com.epam.enums.AccountType;
import main.java.com.epam.enums.UserStatus;
import main.java.com.epam.model.Account;
import main.java.com.epam.model.User;
import main.java.com.epam.utils.CreateAService;

/**
 * The Class UserService.
 *
 * @author Manas
 */
public class UserService implements Services<User> {
	
	/** The dao object. */
	Dao<User> daoObject;
	
	/**
	 * Instantiates a new user service.
	 */
	public UserService() {
		daoObject = new DaoImplementationUser();
	}
	
	/**
	 * Gets the dao.
	 *
	 * @return the dao
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public Dao<User> getDao() throws IOException {
		return daoObject;
	}

	/** The new created user status. */
	UserStatus newCreatedUserStatus;
	
	/**
	 * Creates the user.
	 *
	 * @param args 
	 * @return true, if successful
	 */
	@Override
	public boolean create(String[] args) {
		User newCreatedUser = new User(args);
		try {
			newCreatedUser = addAccountToUser(AccountType.valueOf(args[5]), newCreatedUser);
		} catch (IOException e) {
			e.printStackTrace();
		}
		newCreatedUser.setUserStatus(UserStatus.ACTIVE);
		newCreatedUserStatus = newCreatedUser.getUserStatus();
		return daoObject.save(newCreatedUser);
	}

	/**
	 * Adds the account to user.
	 *
	 * @param accountType the account type
	 * @param newCreatedUser the new created user
	 * @return the user
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public User addAccountToUser(AccountType accountType, User newCreatedUser) throws IOException {
		CreateAService serva = CreateAService.getInstance();
		AccountService accServ = serva.getAccService();
		String[] args = {Double.toString(500.0),accountType.toString()};
		if(accServ.create(args)) {
			Account acc = accServ.getDetails(1);
			newCreatedUser.addAccount(acc);
			}
		return newCreatedUser;
	}

	/**
	 * Delete user.
	 *
	 * @param t 
	 * @return true, if successful
	 */
	@Override
	public boolean delete(User t) {
		t.setUserStatus(UserStatus.INACTIVE);
		return daoObject.delete(t);
	}

	/**
	 * Update user.
	 *
	 * @param t 
	 * @param args 
	 * @return true, if successful
	 */
	@Override
	public boolean update(User t, String[] args) {
		t.setFirstName(args[0]);
		t.setLastName(args[1]);
		t.setGender(args[2]);
		t.setCity(args[3]);
		daoObject.update(t, args);
		return true;
	}

	/**
	 * Gets the details.
	 *
	 * @param t 
	 * @return the details
	 */
	@Override
	public User getDetails(long t) {
		return (User) daoObject.get(t).get();
	}

	/**
	 * Gets the user status.
	 *
	 * @return the user status
	 */
	public UserStatus getUserStatus() {
		return newCreatedUserStatus;
	}

}
