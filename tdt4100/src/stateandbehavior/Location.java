package stateandbehavior;

public class Location {
	
	int x;
	int y;
	
	Location(){
		
	}
	void left(){
		x+=-1;
	}
	
	void right(){
		x+=1;
	}
	
	void up(){
		y+=-1;
	}
	
	void down(){
		y+=1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Location location = new Location();
		
		location.left();
		location.left();
		location.left();
		location.up();
		location.up();
		System.out.println(location);
		
	}
	@Override
	public String toString() {
		return "Location [x=" + x + ", y=" + y + "]";
	}

}
