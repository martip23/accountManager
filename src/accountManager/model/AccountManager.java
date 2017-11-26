package accountManager.model;

import java.util.ArrayList;
import accountManager.model.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Takes a bank account file and parses file information.
 * @author Patrick Martinez
 */
public class AccountManager {
	
	final int setLength = 3;
	ArrayList<String> accountData = new ArrayList();
	String filename;
	
	/**
	 * Creates array with file information
	 * @param filename
	 * @throws InvalidInputFileException 
	 */
	public AccountManager(String filename) throws InvalidInputFileException{
		filename = filename;
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
	public AccountModel selectAccount(int index){
		//Navigate to first element in selected account
		int i = ((index-1) * setLength);
		AccountModel model = new AccountModel(accountData.get(i),
				Integer.parseInt(accountData.get(++i)),
				Integer.parseInt(accountData.get(++i)));
		return model;
	}
	
	public void saveAccount(AccountModel model) {
		
		Boolean found;
		int index = 1;
		
		while (!found && accountData.size() < index) {
			if((Integer.parseInt(accountData.get(index)) == model.getID())) {
				found = true;
				accountData.set((index + 1), Integer.toString(model.getBalance()));
			}
		}
		File fnew = new File(filename);
		try {
			FileWriter fw = new FileWriter(fnew, false);
			for (int i = 0; i < accountData.size(); i++) {
				fw.write(accountData + " ");
				if ((i + 1) % setLength == 0) {
					fw.write("\n");
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}		
}
