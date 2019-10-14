/**
 * 
 */
package main.java.com.epam.utils;

/**
 * The Class GenerateAccountNumber.
 *
 * @author Manas
 */
public class GenerateAccountNumber {
   private static long accountNumber=0;

    /**
     * Instantiates a new generate account number.
     */
    public GenerateAccountNumber() {
        accountNumber +=1 ;
    }

    /**
     * Gets the account number.
     *
     * @return account number
     */
    public long getGeneratedAccountNumber() {
        return accountNumber;
    }

}
