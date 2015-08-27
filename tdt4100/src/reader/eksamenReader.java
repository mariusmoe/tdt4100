package reader;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.management.RuntimeErrorException;

public class eksamenReader {

	
	public void read(InputStream input){
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		
		String line = null;
		
		while ((line = reader.readLine()) != null){
			int pos = line.indexOf('#');
			if (pos >= 0 ){
				line = line.substring(0, pos);
			}
		line = line.trim();
		if (line.length() == 0){
			continue;
		}
		pos = line.indexOf('-');
		if (pos >=0){
			String word = line.substring(0, pos);
			String rest = line.substring(pos+1);
			if(rest.length()==0){
				addWord(line);
			}else{
				String[] suffixes = rest.split(".");
				for (int i=0; i < suffixes.length;i++){
					addWord(preffix + suffixes[i]);
				}
			}
		}
		else{
			addWord(line);
		}
		
		}
	}

	private void addWord(String line) {
		// TODO Auto-generated method stub
		
	}
	
	public void foo() throws IOException {
		read(null);
		
	}
	public void foo2() {
		try{
			read(null);
			
		} catch(IOException e){
			throw new RuntimeException("");
		}
		
		
	}	
	
}
