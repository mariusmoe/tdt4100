package eksamen2014kont;

public class Account {
	
	private int balance =0;
	private int withdrawLimit=0;
	String accountID;
	
	Account(String ID){
		accountID=ID;
	}
	
	//skal kanskje ikke være med 
	Account(){}
	
	public int getBalance(){
		return balance;
	}
	
	public void deposit(int amount){
		checkAmount(amount);
		balance += amount;
	}

	public void withdraw(int amount){
		checkAmount(amount);
		checkLimit(amount);
		balance -= amount;
	}
	
	private void checkLimit(int amount) {
		if (!(withdrawLimit==0) && amount>withdrawLimit){
			throw new IllegalArgumentException("amount was bigger than the withdrawLimit, amount was" + amount+ " and the limit was " + withdrawLimit);
		}
	}

	public String getAccountId(){
		return accountID;
		
	}
	
	private void checkAmount(int amount) {
		if (amount < 0){
			throw new IllegalArgumentException("amount is less then 0, and was: " + amount);
		}
	}

	public int getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(int withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}

}
