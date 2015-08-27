package eksamen2014kont;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAccountTest {

	@Test
	public void test() {
		
		Account account = new Account();
		
		assertEquals(0, account.getBalance());
		account.deposit(100);
		assertEquals(100, account.getBalance());
		assertEquals(100, account.getBalance());
		account.withdraw(150);
		assertEquals(-50, account.getBalance());
		try{
			account.withdraw(-50);
		}
		catch(Exception e){}
		assertEquals(-50, account.getBalance());
	}

}
