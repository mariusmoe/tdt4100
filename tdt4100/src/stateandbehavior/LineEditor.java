package stateandbehavior;

import javafx.scene.text.Text;

public class LineEditor {
	
	String text="";
	int insertionIndex=0;
	
	public LineEditor(){
	
		
	}
	void left(){
		if (insertionIndex>0){
			insertionIndex+=-1;
		}
	}
	
	void right(){
		if (insertionIndex<text.length()){
			insertionIndex+=1;
		}
	}

	void insertString(String s){
		
		
		StringBuffer sBuffer = new StringBuffer(text);
	    sBuffer.insert(insertionIndex,s);
	    text = sBuffer.toString();  
	    insertionIndex+=s.length();	
	}
	
	void deleteLeft(){
		if (insertionIndex>0){
			StringBuffer sb = new StringBuffer(text);
		      sb.delete(insertionIndex-1,insertionIndex); 
		      text = sb.toString();  
		      left();
		}	
	}
	
	void deleteRight(){
		if (insertionIndex<text.length()){
			StringBuffer sb = new StringBuffer(text);
		      sb.delete(insertionIndex,insertionIndex+1); 
		      text = sb.toString();      
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LineEditor lineEditor = new LineEditor();
		lineEditor.insertString("jexercise er");
		System.out.println(lineEditor);
		lineEditor.insertString(" teit!");
		System.out.println(lineEditor);
		lineEditor.left();
		lineEditor.left();
		lineEditor.left();
		lineEditor.left();
		lineEditor.left();
		lineEditor.insertString("kjempe ");
		lineEditor.right();
		lineEditor.right();
		lineEditor.right();
		lineEditor.right();
		lineEditor.right();
		lineEditor.insertString(" som ikke vil gi meg godkjent");
		System.out.println(lineEditor);

		lineEditor.deleteLeft();
		lineEditor.deleteLeft();
		lineEditor.deleteLeft();
		lineEditor.deleteLeft();
		lineEditor.deleteLeft();
		System.out.println(lineEditor);
		
		
		lineEditor.left();
		lineEditor.left();
		lineEditor.left();
		lineEditor.left();
		lineEditor.left();
		lineEditor.deleteRight();
		lineEditor.deleteRight();
		System.out.println(lineEditor);
	
	}
	@Override
	public String toString() {
		return "LineEditor [text=" + text + ", insertionIndex="
				+ insertionIndex + "text med |="+text.substring(0, insertionIndex)+"|"+ text.substring(insertionIndex)+"]";
	}

}
