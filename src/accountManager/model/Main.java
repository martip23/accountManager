package accountManager.model;
import accountManager.controller.*;

/**
 * Holds main class and starts accountManager. Pulls account data from a csv
 * file and passes it to the Controller for building.
 * @author martip23
 *
 */
public class Main {
	
	/**
	 * Takes a filename as an argument and loads the account data from the file
	 * supports .csv. Syntax is as follows 
	 * 		{String:Name},{Int:UniqueID},{String:Amount}
	 * Multiple accounts should be separated by line breaks
	 * @param args filename containing account information
	 */
	public static void main(String[] args) {
		new AccountController();
		System.out.println("Successfully compiled");
	}
}
