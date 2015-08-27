package eksamen2012ord;

import com.sun.javafx.geom.Rectangle;


@SuppressWarnings("restriction")
public class TimeSlot {

	String description;
	DayTime start;
	DayTime duration;
	int durMinutes;
	DayTime end;
	
	TimeSlot(String s, int start1, int minutes1, int duration1){
		
		this.durMinutes=duration1;
		this.description=s;
		this.start=new DayTime(start1,minutes1);
		
		//dummy
		this.duration=new DayTime((int) Math.floor(duration1/60), (int) (duration1%60));
		
		this.end= new DayTime((int) Math.floor(start.getHour()+duration1/60), (int) start.getMinutes()+duration1%60);
		
		
	}

	@Override
	public String toString() {
		return description + "@" + start.toString() + "-" + end.toString();
	}
	
	 DayTime getStartTime(){
		return start;
	}
	 
	 DayTime getEndtime(){
		 return end;
	 }
	 
	 int getDuration(){
		 return durMinutes;
	 }
	
	boolean contains(int hours, int minutes){
		 //Rectangle(int start X, int start Y, int bredd, int høyde)
		 Rectangle bolk = new Rectangle(start.getHour()*60+start.getMinutes(),0,durMinutes,1);
		 Rectangle time = new Rectangle(hours*60+minutes,0,0,1);		 
		 return (end.getHour()==hours && end.getMinutes()==minutes) ? true : bolk.contains(time) || time.contains(bolk);
	 }
	boolean overlaps(TimeSlot timeSlot){
		 //Rectangle(int start X, int start Y, int bredd, int høyde)
		 Rectangle bolk = new Rectangle(start.getHour()*60+start.getMinutes(),0,durMinutes,1);
		 Rectangle time = new Rectangle(timeSlot.start.getHour()*60+timeSlot.start.getMinutes(),0,timeSlot.durMinutes,1);		 
		 return (end.getHour()==timeSlot.start.getHour() && end.getMinutes()==timeSlot.start.getMinutes()) ? false : bolk.contains(time) || time.contains(bolk);//time.contiains block
	 }
	 
	 
	 
	 
}
