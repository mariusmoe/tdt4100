package oving1;


public class Account {
	Account(){
		
	}
	public double balance=0;
	public double interestRate=0.15;
	
	
	public void deposit(double amount){
		if (amount>=0){
			balance+=amount;
		}
		
	}
	
	
	public void addInterest(){
		//interestRate=interest_Rate;
		//Account.deposit();
		balance+=(balance*(interestRate/100));
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account account = new Account();
		//account.main();
		
		
		account.deposit(500);
		account.addInterest();
		account.deposit(200);
		System.out.println(account);
		//account.addInterest(0.14);
		//System.out.println(account);
		
	}


	@Override
	public String toString() {
		return "Account [balance=" + balance + ", interestRate=" + interestRate
				+ "]";
	}

}
