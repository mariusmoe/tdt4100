package debugging;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StringMergingIterator implements Iterator<String> {

	private Iterator<String> first;
	private Iterator<String> second;
	private boolean turnSwitch;

	public StringMergingIterator(Iterator<String> first, Iterator<String> second){
		this.first = first;
		this.second = second;
		this.turnSwitch = true;
	}

	@Override
	public boolean hasNext() {
		return first.hasNext() || second.hasNext();		//skal det være && ??
	}

	@Override
	public String next() {
		
		if(! hasNext()){ throw new NoSuchElementException(); }
		else{
			
		

		String result = null;
		
		if(! first.hasNext()){
			result = second.next();		//skal denne være second??
		} 
		else if(! second.hasNext()){
			result = first.next();
		} 
		else {
			if(turnSwitch){
				result = first.next();
				turnSwitch = false;
			}
			else{			//(!turnSwitch)
				result = second.next();
				turnSwitch = true;
			}
			
		}
		
		return result;
	}
	}
	
	
}
