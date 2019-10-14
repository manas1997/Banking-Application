/**
 * 
 */
package main.java.com.epam.dao;

import java.util.List;
import java.util.Optional;

/**
 * The Interface Dao.
 *
 * @author Manas
 * @param <T> the generic type
 */
public interface Dao<T> {

    /**
     * Gets the.
     *
     * @param id the id
     * @return the optional
     */
    Optional<T> get(long id);

    /**
     * Gets the all.
     *
     * @return the all
     */
    List<T> getAll();

    /**
     * Save.
     *
     * @param t the t
     * @return true, if successful
     */
    boolean save(T t);

    /**
     * Update.
     *
     * @param t the t
     * @param params the params
     * @return true, if successful
     */
    boolean update(T t, String[] params);

    /**
     * Delete.
     *
     * @param t the t
     * @return true, if successful
     */
    boolean delete(T t);
}
