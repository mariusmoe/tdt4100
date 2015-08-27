package games.sudoku.sudoku3;

import java.lang.Math;
public class SudokuCell {
	
	
	private Integer value;
	private Integer block;
	private Integer xpos;
	private Integer ypos;
	boolean assignable;
	
	public Integer getCellValue(){
		return value;
	}
	void setCellValue(Integer i){
		value = i;
	}
	
	boolean isAssignable(){
		return assignable;
	}
	
	void setIsAssignable(boolean b){
		assignable=b;
	}
	
	//setCellValue med STRING!!!
	public void setCellValue(String string) {
		// TODO Auto-generated method stub
		try {
			value = Integer.valueOf(string);
		} catch (Exception e) {
			value = 0;
			setIsAssignable(true);
		}
	}

	public int getBlock(){
		return block;
	}
	
	public void setGetBlock(Integer x){
		Double a=0.0;
		a = Math.floor(x/27);
		for (int b=0;b<3;b++){
			if ((x%9)<=(2+3*b) && x<(21+3*b+a*27)){
				block = a.intValue()*3+b;
				break;
			}
		}
				
				
		
		
		/*
		if ((x%9)<=2 && (x%3.)<=2 && x<21){
			block = 0;
		}	
		if ((x%9)>2 && (x%9)<=5 && (x%3.)<=2 && x<=25){
			block = 1;
		}	
		if ((x%9)>5 && (x%9)<=8 && (x%3.)<=2 && x<=27){
			block = 2;
		}	
//----------------
		if ((x%9)>=0 && (x%9)<=2 && (x%3.)<=2 && x > 26 && x<=48){
			block = 3;
		}			
		if ((x%9)>2 && (x%9)<=5 && (x%3.)<=2 && x >= 29 && x<=51){
			block = 4;
		}	
		if ((x%9)>5 && (x%9)<=8 && (x%3.)<=2 && x >= 32 && x<=54){
			block = 5;
		}
//---------------
		if ((x%9)>=0 && (x%9)<=2 && (x%3.)<=2 && x >= 54 && x<=75){
			block = 6;
		}
		if ((x%9)>2 && (x%9)<=5 && (x%3.)<=2 && x >= 57 && x<=78){
			block = 7;
		}
		if ((x%9)>5 && (x%9)<=8 && (x%3.)<=2 && x >= 60 && x<=81){
			block = 8;
			
		}*/		
	}
	
	public Integer getPlaceX(){
		return xpos;
	}
	public Integer getPlaceY(){
		return ypos;
	}
	
	public void setPlace(Integer x, Integer y){
		xpos=x;
		ypos=y;
	}
}
