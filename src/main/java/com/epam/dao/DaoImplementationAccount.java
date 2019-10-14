/**
 * 
 */
package main.java.com.epam.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import main.java.com.epam.enums.AccountStatus;
import main.java.com.epam.model.Account;

/**
 * The Class DaoImplementationAccount.
 *
 * @author Manas
 */
public class DaoImplementationAccount implements Dao<Account> {

	/** The map. */
	Map<Long, Account> map;

	/** The list of accounts. */
	List<Account> listOfAccounts;

	/**
	 * Instantiates a new dao implementation account.
	 */
	public DaoImplementationAccount() {
		map = new HashMap<Long, Account>();
		listOfAccounts = new ArrayList<Account>();
	}

	/**
	 * Gets the account
	 *
	 * @param id the id
	 * @return the optional
	 */
	@Override
	public Optional<Account> get(long id) {
		if (map.containsKey(id)) {
		}
		return Optional.ofNullable(map.get(id));
	}

	/**
	 * Gets all the accounts.
	 *
	 * @return the all
	 */
	@Override
	public List<Account> getAll() {
		return listOfAccounts;
	}

	/**
	 * Gets the map.
	 *
	 * @return the map
	 */
	public Map<Long, Account> getMap() {
		return map;
	}

	/**
	 * Save the account.
	 *
	 * @param t the t
	 * @return true, if successful
	 */
	@Override
	public boolean save(Account t) {
		if (map.containsKey(t.getAccountNumber())) {
			return false;
		}
		listOfAccounts.add(t);
		map.put(t.getAccountNumber(), t);
		return true;
	}

	/**
	 * Update the account.
	 *
	 * @param t      the t
	 * @param params the params
	 * @return true, if successful
	 */
	@Override
	public boolean update(Account t, String[] params) {
		Account removed = map.get(t.getAccountNumber());
		map.remove(t.getAccountNumber());
		listOfAccounts.remove(removed);
		listOfAccounts.add(t);
		map.put(t.getAccountNumber(), t);
		return true;
	}

	/**
	 * Delete.
	 *
	 * @param t the t
	 * @return true, if successful @
	 */
	@Override
	public boolean delete(Account t) {
		t.setAccountStatus(AccountStatus.INACTIVE);
		return true;
	}

}
