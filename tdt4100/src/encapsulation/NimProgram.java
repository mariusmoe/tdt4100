package encapsulation;

import java.util.Scanner;



public class NimProgram {
	
	
	
	 static void main() {
		
	        Scanner scanner = new Scanner(System.in); // declare and initialise the scanner variable
	        System.out.println("velg en pileSize(tom vil gi pileSize=10)");
	        
	        System.out.print(" > ");
	        String token1 = scanner.nextLine();  // declare and initialise the token variable
	        
	        int tall=10;
	        //ikke ideilt !!!
	        
	        if (token1.length()==0){
            	
            	//Nim.Nim(token1);
	        	Nim nim = new Nim();
	        	
            }
	        else{
	        	tall = Integer.valueOf(token1);
	        	//Nim nim = new Nim(Integer.valueOf(token1));
	        	
	        }
	       
			
			
	        
	       
	        Nim nim = new Nim();
	        
	        while (true) {
	        	//Nim nim = new Nim(tall);

	        	
	        	System.out.print(" > ");
	            String token = scanner.nextLine();  // declare and initialise the token variable
	        	
	        	String string1 = token;
				String[] parts1 = string1.split("\\,");
				String part1 = parts1[0]; // 
				String part2 = parts1[1]; // 
	        	
	           
	            if (isInteger(part1) && isInteger(part2)){
	            	
	            	nim.removePieces(Integer.valueOf(part1), Integer.valueOf(part2));
	            	System.out.println(nim.getPile(Integer.valueOf(part2)));
	            	
	            	System.out.println("getpile1: "+nim.getPile(0));
	        		System.out.println("getpile2: "+nim.getPile(1));
	        		System.out.println("getpile3: "+nim.getPile(2));
	            }
	            
	            else if (token.equals("exit")){
	            	break;
	            }
	           
	        }
	        
	        System.out.println("program exited");
	        scanner.close();
	    }

	 public static boolean isInteger(String str) {
		    try {
		        Integer.parseInt(str);
		        return true;
		    } catch (NumberFormatException nfe) {
		        return false;
		    }
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NimProgram.main();
		
	}

}
