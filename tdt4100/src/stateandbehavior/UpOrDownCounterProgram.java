package stateandbehavior;


import java.util.Scanner;


public class UpOrDownCounterProgram {
	

    static void run() {
        Scanner scanner = new Scanner(System.in); // declare and initialise the scanner variable
        System.out.println("Tast inn et tall");
        
        System.out.print(" > ");
        String token1 = scanner.nextLine();  // declare and initialise the token variable
        
        
		String string1 = token1;
		String[] parts1 = string1.split("\\,");
		String part1 = parts1[0]; // 
		String part2 = parts1[1]; // 
		
        UpOrDownCounter upOrDownCounter = new UpOrDownCounter(Integer.valueOf(part1), Integer.valueOf(part2));
        System.out.println(upOrDownCounter.getCounter());
       
        
        while (true) {
        	
            System.out.print(" > ");
            String token = scanner.nextLine();  // declare and initialise the token variable
            

            if (token.length()==0){
            	
            	upOrDownCounter.run();
            	System.out.println(upOrDownCounter.getCounter());
            }
            
            else if (token.equals("exit")){
            	break;
            }
        }
        
        System.out.println("program exited");
        scanner.close();
    }

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		UpOrDownCounterProgram.run();
	}

}
