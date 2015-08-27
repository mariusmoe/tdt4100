package stateandbehavior;

public class UpOrDownCounter {
	
	int counter;
	int end;
	
	UpOrDownCounter(int start, int end){
		this.counter = start;
		this.end = end;
		
		if (start==end){
			throw new IllegalArgumentException("Shit happend D: mest sannsynlig var de to tallene like");
		}
	}
	
	public int getCounter(){
		
		return counter;
		
	}

	public boolean count(){
		if (counter>end){
			counter+=-1;
		}
		else if (counter<end){
			counter+=1;
		}
		if (counter == end) {
			return false;
		}
		return true;
		
	}
	
	public void run() {
        
        System.out.println(count());
        
        
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UpOrDownCounter upOrDownCounter = new UpOrDownCounter(1, 3);
		upOrDownCounter.run();
	}

}
