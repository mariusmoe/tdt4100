package eksamen2014ord;

import java.io.PrintStream;
import java.util.ArrayList;



public class Question {
	
	String correctAnswer;
	String question;
	private ArrayList<String> alternative = new ArrayList<>();
	// Vi antar senere i oppgaven at alternativ ved index 0 er riktig.
	
	public Question(String q, String ans){
		this.question = q;
		this.correctAnswer= ans;
	}
	
	public Question(String q, String ans, String alt){
		this.question = q;
		this.correctAnswer = ans;
		
		 String string = alt;
		 String[]  parts = string.split("\n");
		 for (String part : parts){
			 alternative.add(part);
		 }
	}
	
	public void askQuestion(PrintStream out){
		if(alternative.equals(null)){
			out.println(question);
		}
		else{
			out.print(question);
			int i =1;
			for(String alt : alternative){
				out.print(i + ": "+ alt + " ");
				i++;
			}
			out.println();//få litt mellomrom inn
		}
	}
	
	public boolean checkAnswer(String answer){
		
		if (answer.equals(correctAnswer)){
			return true;
		}
		try{
			if(alternative.get((Integer.valueOf(answer))-1).equals(correctAnswer)){
				return true;
			}
		}
		catch (Exception e){}
		return false;
		
	}

	
	//trenger ingen get/set metoder her da en har askQuestion og kontruktører

}
