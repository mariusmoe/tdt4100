package interfaces;

import java.util.Comparator;

public class NamedComparator implements Comparator<Named>{

	@Override
	public int compare(Named o1, Named o2) {
				
		String f1 = o1.getGivenName();
		String f2 = o2.getGivenName();
		
		String e1 = o1.getFamilyName();
		String e2 = o2.getFamilyName();
		
		if (!(e1.equals(e2))){
			return (e1).compareTo(e2);
		}
		else{
			return (f1).compareTo(f2);
		}
		
		
	}

}
