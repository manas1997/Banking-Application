/**
 * 
 */
package main.java.com.epam.service;

/**
 * @author Manas
 */
public interface Services<T> {
	
	/**
	 * Creates the.
	 *
	 * @param args the args
	 * @return true, if successful
	 */
	public boolean create(String args[]);
	
	/**
	 * Delete.
	 *
	 * @param t the t
	 * @return true, if successful
	 */
	public boolean delete(T t);
	
	/**
	 * Update.
	 *
	 * @param t the t
	 * @param args the args
	 * @return true, if successful
	 */
	public boolean update(T t,String args[]);
	
	/**
	 * Gets the details.
	 *
	 * @param t the t
	 * @return the details
	 */
	public T getDetails(long t);
}
