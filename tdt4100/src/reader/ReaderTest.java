package reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReaderTest {

	
	void ReadText(InputStream input) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(input));
		
	}
}
