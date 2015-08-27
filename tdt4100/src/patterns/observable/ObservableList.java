package patterns.observable;

import java.util.ArrayList;
//import java.util.Collection;


public abstract class ObservableList {

	protected int maxSize;
	
	ArrayList<Object> results = new ArrayList<Object>();
	
	protected ArrayList<ObservableListListener> listListener = new ArrayList<ObservableListListener>();
	
	abstract boolean acceptsElement(Object o);
	
	Object getElement(int n){
		return results.get(n);
	}
	
	int size(){
		return results.size();
	}

	protected void addElement(int n, Object o) {
		//ObservableHighscoreList ob = new ObservableHighscoreList(10);
		//results.add(n);
		//if (n>maxSize){
	//		throw new IndexOutOfBoundsException();
		//}
		 if (!acceptsElement(o)){
			throw new IllegalArgumentException();
		}
		else{
			results.add(n, o);	
			
			    for (ObservableListListener listListener1 : listListener) {
			    	listListener1.listChanged(this, n);
			    }
		}
	}
	
	protected void addElement(Object n) {
		if (!acceptsElement(n)){
			throw new IllegalArgumentException();
		}
		results.add(n);
	}
	
	protected void removeElement(int n) {
		results.remove(n);
	}
	
	void addObservableListListener(ObservableListListener l){
		if (!listListener.contains(l)){
			listListener.add(l);
		}	
	}
	
	void removeObservableListListener(ObservableListListener l){
		if (listListener.contains(l)){
			listListener.remove(l);
		}
	}
}
