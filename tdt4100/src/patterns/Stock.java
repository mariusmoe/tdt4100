package patterns;

import java.util.ArrayList;
import java.util.List;


public class Stock {
	
	String ticker;
	private double kurs;
	List<StockListener> listeners= new ArrayList<>();
	
	
	Stock(String s, double d){
		this.ticker=s;
		this.kurs=d;
	}
	
	void setPrice(double d){
		//skal denne metoden utløse unntak dersom den blir null eller negativ eller om den er det????
		
		//er kurs og pris det samme???
		
		if (this.kurs<=0){
			throw new IllegalArgumentException();
		}
		else{
			this.kurs=d;
		}
	}
	
	String getTicker(){
		return this.ticker;
	}
	
	double getPrice(){
		return this.kurs;
	}
	
	
	void addStockListener(StockListener st){
		this.listeners.add(st);
	}

	void removeStockListener(StockListener st){
		this.listeners.remove(st);
	}
}
