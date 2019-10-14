
package main.java.com.epam.dao; 
import java.util.List;
import java.util.Optional;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserDao.
 *
 * @author Manas
 * @param <T> the generic type
 */
public interface UserDao<T> extends Dao<T> {
    
	/**
	 * Gets the user.
	 *
	 * @param id the id
	 * @return the optional
	 */
    Optional<T> get(long id);

  

	/**
	 * Gets all the user.
	 *
	 * @param id the id
	 * @return the optional
	 */
    List<T> getAll();

    /**
  	 * Save the user.
  	 *
  	 * @param t the t
  	 * @return true, if successful
  	 */
    boolean save(T t);
    /**
 	 * Update the user.
 	 *
 	 * @param t the t
 	 * @param params the params
 	 * @return true, if successful
 	 */
    boolean update(T t, String[] params);

	/**
	 * Delete the user.
	 *
	 * @param t the t
	 * @return true, if successful
	 */
    boolean delete(T t);
}
