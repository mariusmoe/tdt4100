package patterns.observable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;



public class HighscoreList {

	int maxSize;
	//Collection<Integer>results;
	ArrayList<Integer> results = new ArrayList<Integer>();
	private Collection<HighscoreListListener> highscoreListListener = new ArrayList<HighscoreListListener>();
	//private Collection<Integer> results = new ArrayList<Integer>();
	
	HighscoreList(int i){
		this.maxSize=i;
	}
	
	int size(){
		return results.size();
	}
	
	int getElement(int n){
		return results.get(n);
	}
	

	
	void addResult(int n){
		
		boolean changeDone = false;
		ArrayList<Integer> results2 = new ArrayList<Integer>(results);
	
		int endringIndex = 0;
		results.add(n);
		Collections.sort(results);
		
		
		if (results.size()<maxSize){
			changeDone=true;
			endringIndex=results.size()-1;
		}
		
		for (int i=0;i<results2.size();i++){
			if (!(results.get(i)==results2.get(i))){
				endringIndex=i;
				changeDone = true;
				break;
			}
		}

		while (results.size()>maxSize){
			results.remove(results.size()-1);
		}
		
		//send message listChanged
		if (changeDone){
	        for (HighscoreListListener highscoreListListener1 : highscoreListListener) {
	        	highscoreListListener1.listChanged(this, endringIndex);
	        }
		}
	}
	

	
	void addHighscoreListListener(HighscoreListListener l){
		if (!highscoreListListener.contains(l)){
			highscoreListListener.add(l);
		}
		
	}
	
	void removeHighscoreListListener(HighscoreListListener l){
		if (highscoreListListener.contains(l)){
			highscoreListListener.remove(l);
		}
	}




}