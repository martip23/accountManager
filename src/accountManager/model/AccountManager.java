package accountManager.model;

import java.util.ArrayList;

/**
 * Takes a bank account file and parses file information.
 * @author Patrick Martinez
 */
public class AccountManager {
	
	public final int setLength = 3;
	ArrayList accountData = new ArrayList();
	
	/**
	 * Creates array with file information
	 * @param filename
	 * @throws InvalidInputFileException 
	 */
	AccountManager(String filename) throws InvalidInputFileException{
		throw new InvalidInputFileException();
	}
	
	public AccountModel SelectAccount(int index){
		//Navigate to first element in selected account
		int i = ((index-1) * setLength);
		return (AccountModel(accountData.get(i),
				accountData.get(++i),
				accountData.get(++i)));
	}
}
