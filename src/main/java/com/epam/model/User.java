package main.java.com.epam.model;

import main.java.com.epam.enums.UserStatus;

/**
 * The Class User.
 *
 * @author Manas
 */
public class User {
	
	/** The user status. */
	private UserStatus userStatus;
    
    /** The id. */
    long id;
    
    /**
     * Gets the id.
     *
     * @return the id
     */
    public long getId() {
		return id;
	}

	/** The first name. */
	String firstName;
    
    /** The last name. */
    String lastName;
    
    /** The gender. */
    String gender;
    
    /** The city. */
    String city;
    
    /** The account. */
    Account account;
    
    /**
     * Gets the account.
     *
     * @return the account
     */
    public Account getAccount() {
		return account;
	}

	/**
	 * Instantiates a new user.
	 *
	 * @param args the args
	 */
    public User(String[] args) {
	this.firstName = args[0];
	this.lastName = args[1];
	this.gender = args[2];
	this.city = args[3];
	this.id = Long.parseLong(args[4]);
    }

    /**
     * Gets the first name.
     *
     * @return first name
     */
    public String getFirstName() {
	return firstName;
    }

    /**
     * Sets the first name.
     *
     * @param firstName the new first name
     */
    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    /**
     * Gets the last name.
     *
     * @return last name
     */
    public String getLastName() {
	return lastName;
    }

    /**
     * Sets the last name.
     *
     * @param lastName the new last name
     */
    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    /**
     * Gets the gender.
     *
     * @return gender
     */
    public String getGender() {
	return gender;
    }

    /**
     * Sets the gender.
     *
     * @param gender the new gender
     */
    public void setGender(String gender) {
	this.gender = gender;
    }

    /**
     * Gets the city.
     *
     * @return city
     */
    public String getCity() {
	return city;
    }

    /**
     * Sets the city.
     *
     * @param city the new city
     */
    public void setCity(String city) {
	this.city = city;
    }
    
    /**
     * Adds the account.
     *
     * @param account the account
     */
    public void addAccount(Account account) {
    	this.account = account;
    }


	/**
	 * Gets the user status.
	 *
	 * @return the userStatus
	 */
	public UserStatus getUserStatus() {
		return userStatus;
	}

	/**
	 * Sets the user status.
	 *
	 * @param userStatus the userStatus to set
	 */
	public void setUserStatus(UserStatus userStatus) {
		this.userStatus = userStatus;
	}
}
