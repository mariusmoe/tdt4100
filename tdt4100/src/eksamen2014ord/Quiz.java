package eksamen2014ord;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Quiz {
	
	private ArrayList<Question> questions = new ArrayList<>();

	public void addQuestion(Question q){
		questions.add(q);
	}
	
	void run(){
		Scanner scanner = new Scanner(System.in);
		
		for (Question question : questions){
			question.askQuestion(System.out);
			String string = scanner.nextLine();
			while(!(question.checkAnswer(string))){
				System.out.println("WRONG!!!");
				string = scanner.nextLine();
			}
		}
		scanner.close();
		
	}
	
	void initFromFile() {
		Scanner inn;
		
		try{
			inn = new Scanner(new FileReader("input.txt"));
		
		
		System.out.println("test init success");
		
		String question = "";
		String answar = "";
		String alt ="";
		
		while (inn.hasNextLine()){
			//hvis hwile løkke får kjøre vet vi at det er et spørsmål og et svar
			System.out.println(("mm"));
			question=inn.nextLine();
			System.out.println(question);
			answar=inn.nextLine();
			System.out.println(answar);
			System.out.println("-------------");
			alt="";
			//Hvis det da finnes en linje til --> som er lengre enn 1 lang, så vet vi at det er alternativ
			if((inn.hasNextLine())){
				String doh = inn.nextLine();
				if (doh.length()>1){
					alt+=doh + "\n";
					while(inn.hasNextLine()){
						String doh2 = inn.nextLine();
						alt+= doh2+ "\n";
						if (doh2.isEmpty()){
							
							break;
						}
					}
					
				}

			}
				
				Question q;
				if(alt.equals("")){
					 q = new Question(question,answar);
				}
				else{
					 q = new Question(question,answar,alt);
				}
				addQuestion(q);
				//continue;
			
			}
			
			
			inn.close();
		
		}
		catch (FileNotFoundException e){System.err.println("øsdlkjskøgmslkørgm");}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args){
		Quiz qiz = new Quiz();
		/*Question q1 = new Question("Hva heter forfatteren av dette programmet?", "marius");
		Question q2 = new Question("Hva heter hovedstaden i norge?", "oslo");
		Question q3 = new Question("hvor høy er Galhøpiggen?", "2469", "2539\n2469\n1111");
		qiz.addQuestion(q1);
		qiz.addQuestion(q2);
		qiz.addQuestion(q3);*/
		System.out.println(System.getProperty("user.dir"));
		
			qiz.initFromFile();
		
		qiz.run();
		
	}
}
