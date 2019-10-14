/**
 * 
 */
package main.java.com.epam.dao;

import java.util.List;
import java.util.Optional;

/**
 * The Interface AccountDao.
 *
 * @author Manas Ranjan Mahapatra
 * @param <T> the generic type
 */
public interface AccountDao<T> extends Dao<T> {

	/**
	 * Gets the account
	 *
	 * @param id the id
	 * @return the optional
	 */
	Optional<T> get(long id);

	/**
	 * Gets all the accounts.
	 *
	 * @return the all
	 */
	List<T> getAll();

	/**
	 * Save the account.
	 *
	 * @param t the t
	 * @return true, if successful
	 */
	boolean save(T t);

	 /**
 	 * Update the account.
 	 *
 	 * @param t the t
 	 * @param params the params
 	 * @return true, if successful
 	 */
	boolean update(T t, String[] params);

	  /**
     * Delete the account.
     *
     * @param t the t
     * @return true, if successful
     */
	boolean delete(T t);
}
