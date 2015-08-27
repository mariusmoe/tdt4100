package eksamen2014kont;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SafeBank extends Bank {

	private Map<Account, Integer> transferLimit = new HashMap<Account, Integer>();
	
	public void setTransferLimit(Account a1, Integer limit){
		transferLimit.put(a1, limit);
	}
	
	@Override
	protected void checkTransaction(Transaction t1){
		Account source = t1.source;
		int amount = t1.amount;
		Date date = t1.date;
		Integer limit = transferLimit.get(source);
		if(transferLimit != null){
			@SuppressWarnings("deprecation")
			int transferSum = getTransferSum(source, date.getYear(), date.getMonth());
			if (transferSum+amount > limit){
				throw new IllegalStateException("montly limit has been exceeded :(");
			}
		}
	}
}
