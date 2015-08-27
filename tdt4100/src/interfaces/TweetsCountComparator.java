package interfaces;

import java.util.Comparator;

public class TweetsCountComparator implements Comparator<TwitterAccount>{

	@Override
	public int compare(TwitterAccount o1, TwitterAccount o2) {
		// TODO Auto-generated method stub
		
		Integer n1 = o1.getTweetCount();
		Integer n2 = o2.getTweetCount();
		
		return n1 < n2 ? 1 : n1 == n2 ? 0 : -1;
		
		
	}
	
	
	

}
