package eksamen2012ord;

public class DayProgram {

	public static void main(String[] args){
		
		TimeSlot t1 = new TimeSlot("Forelesning", 06, 05, 70);
		//TimeSlot t2 = new TimeSlot("Kaffe", 11, 30, 40);
		TimeSlot t3 = new TimeSlot("Lunch", 12, 15, 20);
		TimeSlot t4 = new TimeSlot("Møte", 14, 30, 30);
		TimeSlot t5 = new TimeSlot("Ovelapp test", 14, 30, 25);
		//TimeSlot t6 = new TDT4100Lecture();

		DayPlan d = new DayPlan();
		
		d.addTimeSlot(t1);
		//d.addTimeSlot(t2);
		d.addTimeSlot(t3);
		d.addTimeSlot(t4);
		d.addTimeSlot(t5);
		//d.addTimeSlot(t6);
		
		System.out.println("Todays plan: "+d.plan.toString());
		
		System.out.println("Contains overlaps: "+d.containsOverlaps());
		
		System.out.println("Fritid: "+ d.getFreeTime());
		
	}
}
