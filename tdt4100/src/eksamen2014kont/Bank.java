package eksamen2014kont;

import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Bank {
	
	ArrayList<Account> accountList = new ArrayList<>();
	ArrayList<Transaction> transactionList = new ArrayList<>();
    Random rand = new Random();
	
	public void addAccount(Account account){
		if (checkIfIdExist(account.getAccountId())){
			throw new IllegalArgumentException("this accountID already exist, the invallid ID was " + account.getAccountId());
		}
		accountList.add(account);
	}

	private boolean checkIfIdExist(String accountID) {
		for (Account a1 : accountList){
			if (a1.getAccountId().equals(accountID)){
				return true;
			}
		}
		return false;
	}
	
	public Account createAccount(){
		int possibleID = createID();
		
		while(checkIfIdExist(String.valueOf(possibleID))){
			possibleID = createID();
		}
		Account a1 = new Account(String.valueOf(possibleID));
		
		addAccount(a1);
		return a1;
		
	}

	private int createID() {
		int possibleID = 0;
		for (int i=0; i<15;i++){
			possibleID+=randInt();
		}
		return possibleID;
	}
	
	public int randInt() {

	    int randomNum = rand.nextInt((0 - 10) + 1);

	    return randomNum;
	}
	protected void checkTransaction(Transaction transaction){}
	
	void transfer(Account source, Account target, int amount) throws Exception{
		if (!(checkIfIdExist(source.getAccountId()) && checkIfIdExist(target.getAccountId()))){
			throw new IllegalArgumentException("target or source does not exist in this bank");
		}
		
		Transaction t1 = new Transaction(source, target, amount);
		checkTransaction(t1);
		
		source.withdraw(amount);
		target.deposit(amount);
		
		transactionList.add(t1);
	}
	
		public Integer getTransferSum(Account account, int year, int month){
			int outSum=0;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date1 = null;
			try {
				date1 = sdf.parse(year + "-"+ "month"+"-00");
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	Date date2 = null;
			try {
				date2 = sdf.parse(year + "-"+ "month"+"-31");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (Transaction t1 : transactionList){
				if (t1.source.equals(account) && t1.date.before(date2) && t1.date.after(date1)){
					outSum += t1.amount;
				}
			}
			
			return outSum;
			
		}
		
	//del 3
		public void doTransactions(InputStream input){
			Scanner scanner = new Scanner(input);
			
			//93739483948377362-3847384958400372:1500
			while(scanner.hasNextLine()){
				String line = scanner.nextLine();
				int dashPos = line.indexOf('-');
				int colonPos = line.indexOf(':');
				
				Account source = getAccount(line.substring(0, dashPos));
				Account target = getAccount(line.substring(dashPos+1, colonPos));
				
				int amount = Integer.parseInt(line.substring(colonPos+1));
				
				try {
					transfer(source, target, amount);
				} catch (Exception e) {//do nothing
					}
				}
				scanner.close();
			}
		

		private Account getAccount(String substring) {
			for (Account a1 : accountList){
				if (a1.getAccountId().equals(substring)){
					return a1;
				}
			}	
			return null;
		}

}
