package eksamen2012ord;

public class DayTime {
	public final int hours, minutes;
	
	public DayTime(int hours, int minutes){
		int extraTimer = 0;
		int minusMinutter=minutes;
		
		if (Math.floor(minutes / 60) >= 1){
			extraTimer= (int) Math.floor(minutes / 60);
			minusMinutter = (minutes % 60);
		}
		
		this.hours=hours+extraTimer;
		this.minutes=minusMinutter;
	}

	@Override
	public String toString() {
		return hours + ":" + minutes;
	}
	
	int getHour(){
		return hours;
	}
	
	int getMinutes(){
		return minutes;
	}
}
