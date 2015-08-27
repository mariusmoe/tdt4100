package patterns.observable;

import java.util.Scanner;


public class HighscoreListProgram implements HighscoreListListener {

	HighscoreList highscoreList;
	
	void init(){
		 highscoreList = new HighscoreList(10);
		 
		 highscoreList.addHighscoreListListener(this);
		 run();
	}
	
	void run(){
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		 while (true) {
			 System.out.print(" > ");
			 String token = scanner.nextLine();  // declare and initialise the token variable
			 
			 try{
				 if (isInteger(token)){
					 int i = Integer.valueOf(token);
					 highscoreList.addResult(i); 
				 }
				 
			 }
			 catch (Exception e){}
		 }
	}

	@Override
	public void listChanged(HighscoreList l, int i) {
		// TODO Auto-generated method stub
		
		System.out.println(l.results+" Endring ved: "+Integer.valueOf(i));
	}
	
	public static boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    }
	    // only got here if we didn't return false
	    return true;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HighscoreListProgram highscoreListProgram = new HighscoreListProgram();

		highscoreListProgram.init();
		//highscoreListProgram.run();
		
	}

}
