package eksamen2012kont;

public class WordListProgram {
	
	public static void main(String[] args) {
		
		WordList l = new WordList();
		
		l.addWord("stress");
		l.addWord("stressende");
		l.addWord("struts");
		
		System.out.println(l.ar);
		
		l.removeWordsStartingWith("stress");
		
		System.out.println(l.ar);

	}

}
