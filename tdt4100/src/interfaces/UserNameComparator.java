package interfaces;

import java.util.Comparator;

public class UserNameComparator implements Comparator<TwitterAccount>{

	@Override
	public int compare(TwitterAccount o1, TwitterAccount o2) {
		String n1 = o1.getUserName();
		String n2 = o2.getUserName();
		
		return (n1).compareTo(n2);
	}



}
