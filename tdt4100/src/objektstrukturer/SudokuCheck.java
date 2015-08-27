package objektstrukturer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SudokuCheck {
	
	int xPos;
	int yPos;
	
	SudokuBoard sudokuBoard = new SudokuBoard();
	
	void makeXY(String xPosString, String yPosString){
		SudokuBoard sudokuBoard = new SudokuBoard();
		
		this.xPos = Integer.valueOf(xPosString);
		this.yPos = Arrays.asList(sudokuBoard.letter).indexOf(yPosString);
	}
	
	boolean cellIsBusy(String xPosString, String yPosString, String newNumber, String Sstring){
		//sjekker med "base" strengen om den er opptatt
		//hvis den er opptatt returner true 
		SudokuBoard sudokuBoard = new SudokuBoard();
		sudokuBoard.make2DArray(Sstring);
		makeXY(xPosString,yPosString);
			
		try{
			if (sudokuBoard.Slist[yPos][xPos].charAt(0) == '('){
			return true;
			}
		}
		catch(NullPointerException e){
			return false;
		}
		
		return false;
	}
	
	//rowcolumnConflict sjekker om det er et gyldig trekk
	boolean rcConflict(String xPosString, String yPosString, String newNumber, String[][] SGame){
		
		//SudokuBoard sudokuBoard = new SudokuBoard();
		
		makeXY(xPosString,yPosString);
		
		for(int i=0;i<9;i++){
			try{
				if(SGame[yPos][i].equals(newNumber) || SGame[yPos][i].equals(newNumber + "*") || SGame[yPos][i].equals("("+newNumber+")")){
					return true;
				}
			}
			catch(NullPointerException e){
			}
		}
		for(int u=0;u<9;u++){
			try{
				if(SGame[u][xPos].equals(newNumber) || SGame[u][xPos].equals(newNumber + "*") || SGame[u][xPos].equals("("+newNumber+")")){
					return true;
				}
			}
			catch(NullPointerException e){
			}	
		}
		return false;
	}
	
	boolean conflict3x3(String xPosString, String yPosString, String newNumber, String[][] SGame){
		
		
		SGame[Arrays.asList(sudokuBoard.letter).indexOf(yPosString)][Integer.valueOf(xPosString)] = newNumber;
		//liste med "hjørneverdier" i 3x3
		//Integer[] corner = {0,3,6,24,27,30,56,59,62};
		makeXY(xPosString,yPosString);
		
		ArrayList<String> arrlist = new ArrayList<String>();
		ArrayList<String> arrlist1 = new ArrayList<String>();
		//
		for (int w=0;w<9;w+=3){
			for (int s=0;s<9;s+=3){
				
				arrlist.clear();
				arrlist.clear();
				System.out.println("Clear");
				for (int i=0;i<3;i++){
					for (int u=0;u<3;u++){
						try{
							//System.out.println("qwert: "+SGame[i+s][u+w]);
							arrlist1.add(SGame[i+s][u+w]);
							if (SGame[i+s][u+w].equals(".")){}
							else if(SGame[i+s][u+w].contains("*")){
								arrlist.add("("+method(SGame[i+s][u+w])+")");
							}
							else if(SGame[i+s][u+w].contains("(")){
								arrlist.add(SGame[i+s][u+w]);
							}
							else{
								arrlist.add("("+SGame[i+s][u+w]+")");
							}					
						}
						catch(NullPointerException e){	
						}
					}
				
				}
				
				//
				System.out.println(arrlist);
				Set<String> set = new HashSet<String>(arrlist);
				if(set.size() < arrlist.size()){
				    return true;
				}
			}
		}
		
		return false;
	}

	//du kan kunn forsøke å skrive tall til brettet 
	boolean isValidInput(String[] parts){
		SudokuBoard sudokuBoard = new SudokuBoard();
		return (isInteger(parts[0]) &&  Arrays.asList(sudokuBoard.letter).contains(parts[1]) && parts[2].length()>0 && isInteger(parts[2]));
	}
	
	public static boolean isInteger(String str) {
	    try {
	        Integer.parseInt(str);
	        return true;
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	}


	public String method(String str) {
	    if (str.length() > 0 && str.charAt(str.length()-1)=='x') {
	      str = str.substring(0, str.length()-1);
	    }
	    return str;
	}
}