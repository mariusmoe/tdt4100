package objektstrukturer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class SudokuSave implements saveInterface{
	
	private Boolean isSave = false;
	

	public String openFile(){
		String sudokuGame="";

		
		JFileChooser chooser = new JFileChooser();
		Scanner in = null;
		if (chooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
			File selectedFile = chooser.getSelectedFile();
			try {
				in = new Scanner(selectedFile);
				String in1 = in.next();


					try {
						char ch = in1.charAt(0);
						if (ch == '$'){
							//its a savefile!!!
							this.isSave = true;
							sudokuGame = in1.substring(1, in1.length());
						}
					} catch (Exception e) {}
					
					if (!isSave){
						sudokuGame=in1;
					}
					
				
				in.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return (sudokuGame);
	}
	
	
	public Boolean getIsSave(){
		return this.isSave;
	}
	
	public void saveFile(String s){
		JFileChooser chooser = new JFileChooser();
		
		if (chooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
			File selectedFile = chooser.getSelectedFile();
			try {
				FileWriter fw = new FileWriter(selectedFile);

				//fw = new FileWriter(selectedFile);
				
				fw.write("$"+s);
				fw.close();		

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	
	

}
