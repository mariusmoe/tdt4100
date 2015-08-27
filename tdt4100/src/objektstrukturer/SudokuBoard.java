package objektstrukturer;


public class SudokuBoard{
	
	String[] letter = new String[]{"a","b","c","d","e","f","g","h","i"};
	
	String[][] Slist = new String[9][9];
	SudokuBoard(){
		//Slist = new String[9][9];
	}
	
	//lager en 2d array av strengen den tar inn
	String[][] make2DArray(String Sstring){
		
		for (int i=0;i<9;i++){
			for (int u=0;u<9;u++){
				try{
					if (Integer.valueOf(Character.toString(Sstring.charAt((i*9)+u))) != null){
						this.Slist[i][u] = "(" + Character.toString(Sstring.charAt((i*9)+u)) + ")";
					}
				}
				catch(NumberFormatException e){
					this.Slist[i][u] = Character.toString(Sstring.charAt((i*9)+u)) ;
				}
			}
		}	
		
		return Slist;
	}
	
	//tar inn strengen gir den til make2DArray og ber om en print
	void printOutBoardString(String Sstring){
		//lag en 2D-array og tegn den opp i konsollen
		drawBoard(make2DArray(Sstring));
	}

	//tar inn 2D-array med String og printer ut noe vakkert
	void drawBoard(String[][] Slist){
	
		for (int i=0;i<Slist.length;i++){
			if (i == 0 || (i)%3==0){
				if (i == 0){
					System.out.print("    ");
					for (int z=0;z<9;z++){
						if ((z)%3==0){
							System.out.print("| ");
						}
						System.out.print(" " + z + "  ");
					}
					System.out.println("");
				}
				System.out.println("----+-------------+-------------+-------------");
			}
			for (int u=0;u<Slist[i].length;u++){
				if (u == 0 || (u)%3==0){
					System.out.print("| ");
					
					if (u == 0){
						System.out.print(letter[i] + " | ");
					}
				}
				//System.out.print(String.format("%1$3s", Slist[i][u]) );			
				System.out.print(StringUtils.center(Slist[i][u], 4));
			}
			System.out.println("");
		}
		//mellomromet mellom der du skriver og brettet over
		System.out.println("\n\n");
	}	
}	