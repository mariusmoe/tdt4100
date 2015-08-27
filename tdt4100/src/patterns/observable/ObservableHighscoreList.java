package patterns.observable;

import java.util.ArrayList;
import java.util.Collections;


public class ObservableHighscoreList extends ObservableList {

	
	ObservableHighscoreList(int i){
		this.maxSize=i;
	}
	
	public boolean acceptsElement(Object o){
		if (o instanceof Integer){
			return true;
		}
		return false;
	}

	public static boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    }
	    // only got here if we didn't return false
	    return true;
	}

	void addResult(int n){
			
		try {
			boolean changeDone = false;
		
			
			ArrayList<Integer> integers = new ArrayList<Integer>();
			for (Object object : results) {
			    integers.add(object != null ? ((Integer) object).intValue() : null);
			}
			
			int endringIndex = 0;
			integers.add(n);
			
			ArrayList<Integer> integers2 = new ArrayList<Integer>(integers);
			Collections.sort(integers);
			if (integers.size()<maxSize){
				changeDone=true;
				endringIndex=integers.size()-1;
			}
			
			for (int i=0;i<integers.size();i++){
				if (!(integers.get(i)==integers2.get(i))){
					endringIndex=i;
					changeDone = true;
					break;
				}
			}

			while (integers.size()>maxSize){
				integers.remove(integers.size()-1);
			}
			
			//send message listChanged			    
			    
			    ArrayList<Object> ob = new ArrayList<Object>();
				for (Object object : integers) {
				    ob.add(object != null ? ((Integer) object).intValue() : null);
				}
			    results = ob;
			  
				if (changeDone){
				    for (ObservableListListener listListener1 : listListener) {
				    	listListener1.listChanged(this, endringIndex);
				    }					 
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
