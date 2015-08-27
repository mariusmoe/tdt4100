package objektstrukturer;

import java.util.Scanner;
import java.util.Arrays;

public class SudokuProgram {
	
	String[][] SGame = new String[9][9];
	SudokuBoard sudokuBoard = new SudokuBoard();
	
	String brett;
	
	void init(){
		//lag en string builder av "base" stringen
		//this.brett = s;
		 SudokuSave sudokuSave = new SudokuSave();
		 SudokuAngre sudokuAngre = new SudokuAngre();
		 
		 String sudoku2 = sudokuSave.openFile();
		 
		 //System.out.println("init: "+sudoku2);
		// System.out.println("init isSave:"+ sudokuSave.getIsSave());
		 
		 if (!sudokuSave.getIsSave()){
			 this.brett = sudoku2;
			 sudokuBoard.make2DArray(brett);
			 this.SGame = sudokuBoard.Slist;
		 }
		 else{
			 this.SGame = sudokuAngre.make2DArray(sudoku2);
		 }
		 
		 sudokuBoard.drawBoard(SGame);
	}
	
	//SudokuBoard sudokuBoard = new SudokuBoard();
			
	void run(){
	
		Scanner scanner = new Scanner(System.in);
		SudokuAngre sudokuAngre = new SudokuAngre();
		
		
		SudokuCheck sudokuCheck = new SudokuCheck();
		System.out.println("f.eks: 0,a:3");
		
		sudokuAngre.move(SGame);
		
	 while (true) {
		 System.out.print(" > ");
		 String token = scanner.nextLine();  // declare and initialise the token variable

		 try {
			
			//deler opp input slik at den kan gis som parametere 
			 String string = token;
			 String[]  parts = string.split("\\,|\\:");
				String part1 = parts[0]; // x rettning	--> disse ble snudd?\
				String part2 = parts[1]; // y rettning
				String part3 = parts[2]; // ønsket endring
				
				System.out.println(part1+" : "+ part2+" : "+ part3);	//priner ut hvor og hva du ønsket å endre

				if (sudokuCheck.isValidInput(parts)){
				 
					 if (sudokuCheck.cellIsBusy(part1, part2, part3, brett)){
						 System.err.println("Du prøvde å endre betingelsene for oppgaven :(");
					 }
					 else{
						 if (sudokuCheck.rcConflict(part1, part2, part3, SGame) || sudokuCheck.conflict3x3(part1, part2, part3, SGame)){
				    		 this.SGame[Arrays.asList(sudokuBoard.letter).indexOf(part2)][Integer.valueOf(part1)] = part3 + "*"; 
						 }
						 else{
							 this.SGame[Arrays.asList(sudokuBoard.letter).indexOf(part2)][Integer.valueOf(part1)] = part3;
						 	}
						 sudokuAngre.move(SGame);
						 sudokuBoard.drawBoard(SGame);
						 //kall på en lagrefunksjon i en lagreklasse
						 //-------------------------------------------------------
					 }
			 }
			 else if (token.equals("exit")){
			 	break;
			 }
			 else{
				 System.err.println("input var ikke gyldig");
			 }
		} catch (Exception e) {
			// Angre
			 if (token.equals("l")){
				 
				 System.out.println("angre!!!"); 
				 this.SGame=sudokuAngre.undo();
				 sudokuBoard.drawBoard(SGame);
			 }
			 else if (token.equals("p")){
				 
				 System.out.println("redo"); 
				 this.SGame=sudokuAngre.redo();
				 sudokuBoard.drawBoard(SGame);
			 }
			 else if (token.equals("u")){
				 
				 System.out.println("save"); 
				 String s = sudokuAngre.makeOneString(SGame);
				 
				 SudokuSave sudokuSave = new SudokuSave();
				 sudokuSave.saveFile(s);
				 sudokuBoard.drawBoard(SGame);
			 }
			 else{
				 System.err.println(e);
				 scanner.close();
				 //throw new NumberFormatException();
			 }
		}
     }
     System.out.println("program exited");
     scanner.close();
 }
	
	//Hva med en set SGame funksjon (kan kalles fra lagre klassen)
	
	public static void main(String[] args) {
		SudokuProgram sudokuProgram = new SudokuProgram();
		sudokuProgram.init();
		sudokuProgram.run();	
	}
}