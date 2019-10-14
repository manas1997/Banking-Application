/**
 * 
 */
package main.java.com.epam.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import main.java.com.epam.model.Transaction;

/**
 * The Class DaoImplementationTransaction.
 *
 * @author Manas
 */
public class DaoImplementationTransaction implements Dao<Transaction> {

	/** The map. */
	Map<Long, Transaction> map;

	/** The list of transactions. */
	List<Transaction> listOfTransactions;

	/**
	 * Instantiates a new dao implementation transaction.
	 */
	public DaoImplementationTransaction() {
		map = new HashMap<Long, Transaction>();
		listOfTransactions = new ArrayList<Transaction>();
	}

	/**
	 * Gets the transaction.
	 *
	 * @param id the id
	 * @return the optional
	 */
	@Override
	public Optional<Transaction> get(long id) {
		return Optional.ofNullable(map.get(id));
	}

	/**
	 * Gets all the accounts.
	 *
	 * @return the all
	 */
	@Override
	public List<Transaction> getAll() {
		return listOfTransactions;
	}

	/**
	 * Gets the map.
	 *
	 * @return the map
	 */
	public Map<Long, Transaction> getMap() {
		return map;
	}

	/**
	 * Save the transaction.
	 *
	 * @param t the t
	 * @return true, if successful
	 */
	@Override
	public boolean save(Transaction t) {
		if (map.containsKey(t.getId())) {
			return false;
		}

		listOfTransactions.add(t);
		map.put(t.getId(), t);
		return true;
	}

	/**
	 * update the transaction.
	 *
	 * @param t the t
	 * @return true, if successful
	 */
	@Override
	public boolean update(Transaction t, String[] params) {
		delete(t);
		listOfTransactions.add(t);
		map.put(t.getId(), t);
		return true;
	}

	/**
	 * Delete the transaction.
	 *
	 * @param t the t
	 * @return true, if successful
	 */
	@Override
	public boolean delete(Transaction t) {
		Transaction removed = map.get(t.getId());
		map.remove(t.getId());
		listOfTransactions.remove(removed);
		return true;
	}

}
