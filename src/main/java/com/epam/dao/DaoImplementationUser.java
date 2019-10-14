/**
 * 
 */
package main.java.com.epam.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import main.java.com.epam.model.User;

/**
 * The Class DaoImplementationUser.
 *
 * @author Mihir_Jain
 */
public class DaoImplementationUser implements UserDao<User> {

	/** The map. */
	Map<Long, User> map;

	/** The list of users. */
	List<User> listOfUsers;

	/**
	 * Instantiates a new dao implementation user.
	 */
	public DaoImplementationUser() {
		map = new HashMap<Long, User>();
		listOfUsers = new ArrayList<User>();
	}

	/**
	 * Gets the user
	 *
	 * @param id the id
	 * @return the optional
	 */
	@Override
	public Optional<User> get(long id) {
		return Optional.ofNullable(map.get(id));
	}

	/**
	 * Gets all the user.
	 *
	 * @param id the id
	 * @return the optional
	 */
	@Override
	public List<User> getAll() {
		return listOfUsers;
	}

	/**
	 * Gets the map.
	 *
	 * @return the map
	 */
	public Map<Long, User> getMap() {
		return map;
	}

	/**
	 * Save the user.
	 *
	 * @param t the t
	 * @return true, if successful
	 */
	@Override
	public boolean save(User t) {
		if (map.containsKey(t.getId())) {
			return false;
		}

		listOfUsers.add(t);
		map.put(t.getId(), t);
		return true;
	}

	/**
	 * Update the user.
	 *
	 * @param t      the t
	 * @param params the params
	 * @return true, if successful
	 */
	@Override
	public boolean update(User t, String[] params) {
		delete(t);
		listOfUsers.add(t);
		map.put(t.getId(), t);
		return true;
	}

	/**
	 * Delete the user.
	 *
	 * @param t the t
	 * @return true, if successful
	 */
	@Override
	public boolean delete(User t) {
		User removed = map.get(t.getId());
		map.remove(t.getId());
		listOfUsers.remove(removed);
		return true;
	}

}
