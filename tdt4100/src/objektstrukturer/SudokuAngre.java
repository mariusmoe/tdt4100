package objektstrukturer;

import java.util.Stack;

public class SudokuAngre {

	private String currentGame;
	String[][] newSGame = new String[9][9];
	Stack<String> undoSt = new Stack<>();
	Stack<String> redoSt = new Stack<>();
	String[][] SGame2 = new String[9][9];
	
	public void move(String[][] sGame) {
		this.SGame2=sGame;
		currentGame = makeOneString(sGame);
		System.out.println(currentGame);
		undoSt.push(new String(currentGame));
		newSGame = make2DArray(currentGame);
		redoSt.removeAllElements();
	}
	private void undone(String s){
		redoSt.push(new String(s));
	}

	public String[][] redo() {
		if (redoSt.size()>1){
			newSGame = make2DArray(redoSt.pop());
			return newSGame;
		}
		return SGame2;
		
	}

	public String[][] undo() {
		if (undoSt.size()>1){
			undone(undoSt.pop());
			//System.out.println("undo: "+ undoSt.peek());
			newSGame = make2DArray(undoSt.peek());
			return newSGame;
		}
		else{
			return SGame2;
		}

		
	}

	//tar inn et sudoku-spill som en streng og gir ut en 2D-Array av spillet
		//denne strengen kan være et spill som allerede er i gang (med * og () )
	public String[][] make2DArray(String currentGame2) {
		// TODO Auto-generated method stub
		
		Integer k = 0;
		for (int i = 0; i < 9; i++) {
			for (int u = 0; u < 9; u++) {
				try{
					if(Character.toString(currentGame2.charAt((i * 9) + u + k)).equals("(")){
						k+=1;
						String s1 = "("+Character.toString(currentGame2.charAt((i * 9) + u + k))+")";
						this.newSGame[i][u] = s1 ;
						k+=1;
					}
					else if(((i * 9) + u + k + 1)<(currentGame2.length()) &&	(Character.toString(currentGame2.charAt((i * 9) + u + k + 1)).equals("*"))){
						this.newSGame[i][u] = Character.toString(currentGame2.charAt((i * 9) + u + k))+"*";
						k+=1;
					}
					else{
						this.newSGame[i][u] = Character.toString(currentGame2.charAt((i * 9) + u + k));
					}					
				}
				catch(NullPointerException e2){}
			}
		}
		return newSGame;
	}

	public String makeOneString(String[][] sGame) {
		// makes a single line out of the 2D-String sGame
		//System.out.println(sGame);
		currentGame="";
		for (int i = 0; i < sGame[0].length; i++) {
			for (int u = 0; u < sGame[0].length; u++) {
				this.currentGame += sGame[i][u];
			}
		}
		return currentGame;
	}
	
}
