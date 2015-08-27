package eksamen2012kont;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;


public class WordList {
	
	public ArrayList<String> ar = new ArrayList<>();
	public ArrayList<String> ret = new ArrayList<>();
	
	boolean containsWord(String word){
		if (ar.contains(word)){
			return true;
		}
		return false;
	}
	
	Collection<String>getWordStartingWith(String prefix) {
		
		for (String word : ar){
			if (word.contains(prefix)){
				ret.add(word);
			}
		}
		return ret;
		
	}
	
	boolean addWord(String word){
		
		String wordToAdd=word.trim();
		
		if (wordToAdd.length()>0){
			if(!(ar.contains(wordToAdd))){
				ar.add(wordToAdd);
				return true;
			}
		}
		return false;
	}
	
	boolean removeWord(String word){
		if (ar.contains(word)){
			ar.remove(word);
			return true;
		}
		return false;
	}
	
	boolean removeWordsStartingWith(String prefix){
		
		boolean change = false;
		for (int i=0;i<ar.size();i++){
			if (ar.get(i).startsWith(prefix)){
				ar.remove(ar.get(i));
				change=true;
				i--;
			}
		}
		return change;
		
	}
	
	String getPrefix(String word, String suffix){
		String returnWord=null;
		if (word.endsWith(suffix)){
			returnWord = word.substring(0, (word.length()-suffix.length()));
		}
		
		return returnWord;
	}
	
	boolean hasSuffixes(){
		return false;
	}
	
	
	
	public void read(InputStream input) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		String line = null;
		while ((line = reader.readLine()) != null) {  //
			int pos = line.indexOf('#');
			if (pos >= 0) {
				line = line.substring(0, pos);
				pos = line.indexOf('-');
				if (pos < 0) {
					addWord(line);
				} else {
					String prefix = line.substring(0, pos).trim();
					String[] suffixes = line.substring(pos + 1).split(",");
					for (int i = 0; i < suffixes.length; i++) {
						addWord(prefix + suffixes[i].trim());
					}
				}
			}
		}
	}
		
}
