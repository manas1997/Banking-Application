/**
 * 
 */
package main.java.com.epam.dao;

import java.util.List;
import java.util.Optional;

/**
 * The Interface TransactionDao.
 *
 * @author Manas
 * @param <T> the generic type
 */
public interface TransactionDao<T> extends Dao<T>{
	   
	/**
	 * Gets the transaction.
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
    	 * Save the transaction.
    	 *
    	 * @param t the t
    	 * @return true, if successful
    	 */
    	boolean save(T t);

    	  /**
         * Delete the transaction.
         *
         * @param t the t
         * @return true, if successful
         */
    	boolean delete(T t);
}
