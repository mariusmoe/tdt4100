package encapsulation;

public class Account {
	
	private double balance;
	private double interestRate;
	
	public Account(double balance, double interestRate){
		if (!notNegative(balance) || !notNegative(interestRate)){
			throw new IllegalArgumentException("feil på 'balance' eller 'interestRate'");
		}
		this.balance = balance;
		this.interestRate = interestRate;

	}
	public double getBalance(){
		return balance;
	}
	
	public double getInterestRate(){
		return interestRate;
	}
	public void setInterestRate(double setInterestRate){
		if (notNegative(setInterestRate)){
			interestRate=setInterestRate;
		}
		else{
			throw new IllegalArgumentException("ikke deposit et negativt beløp");
		}
		
		
		
	}
	
	void deposit(double amount){
		if (notNegative(amount)){
			balance+=amount;
		}
		else{
			throw new IllegalArgumentException("ikke deposit et negativt beløp");
		}
	}
	
	void withdraw(double amount){
		if (notNegative(amount)){
			if (balance-amount<0){
				throw new IllegalStateException("overtrukket konto D:");
			}
			else{
				balance-=amount;
			}
		}
		else{
			throw new IllegalArgumentException("ikke deposit et negativt beløp");
		}
	}
	
	//returnerer true når tall er større enn 0 og false når tall er mindre enn null
	private boolean notNegative(double tall){
		if(tall>=0){
			return true;
		}
		else{
			return false;
		}
	}
	
	
	@Override
	public String toString() {
		return "Account [balance=" + balance + ", interestRate=" + interestRate
				+ "]";
	}
	public static void main(String[] args) {
		Account account = new Account(-5000 , -5);
		System.out.println(account);

	}

}
