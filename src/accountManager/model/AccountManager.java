package accountManager.model;

import java.util.ArrayList;
import accountManager.model.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Takes a bank account file and parses file information.
 * @author Patrick Martinez
 */
public class AccountManager {
	
	public final int setLength = 3;
	ArrayList<String> accountData = new ArrayList();
	
	/**
	 * Creates array with file information
	 * @param filename
	 * @throws InvalidInputFileException 
	 */
	AccountManager(String filename) throws InvalidInputFileException{
		File file = new File(filename);
		
		try {
			Scanner sc = new Scanner(file);
			
			while (sc.hasNext()) {
				accountData.add(sc.next());
			}
			sc.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Create AccountModel and return
	 * @param index Which account to load
	 * @return AccountModel with parameters
	 */
	public AccountModel SelectAccount(int index){
		//Navigate to first element in selected account
		int i = ((index-1) * setLength);
		AccountModel model = new AccountModel(accountData.get(i),
				Integer.parseInt(accountData.get(++i)),
				Integer.parseInt(accountData.get(++i)));
		return model;
	}
}
