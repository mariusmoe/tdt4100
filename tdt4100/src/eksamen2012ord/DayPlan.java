package eksamen2012ord;

import java.util.ArrayList;
import java.util.Collection;

public class DayPlan {

	ArrayList<TimeSlot> plan = new ArrayList<>();
	TimeSlot forelesning;
	
	DayPlan(){
		TimeSlot t1 = new TDT4100Lecture();
		forelesning=t1;
		addTimeSlot(t1);
	}
	
	void sortTimeSlot(){
		
		this.plan.sort((a,b) -> {
			if ((a.start.getHour()*60+a.start.getMinutes()) == (b.start.getHour()*60+b.start.getMinutes())){
				return a.durMinutes - b.durMinutes;
			}
		else{
			return ((a.start.getHour()*60+a.start.getMinutes()) - (b.start.getHour()*60+b.start.getMinutes()));
		}
			
		});
	}
	
	void addTimeSlot(TimeSlot timeSlot){
		checkTimeSlot(timeSlot);
		plan.add(timeSlot);
		sortTimeSlot();
	}
	
	private void checkTimeSlot(TimeSlot timeSlot) {
		if(!(timeSlot.equals(forelesning))){
			if(timeSlot.overlaps(forelesning)){
				throw new IllegalArgumentException("Du kan ikke unngå forelesningen!!! D:");
			}
		}
		
		
	}

	void removeTimeSlot(TimeSlot timeSlot){
		plan.remove(timeSlot);
		sortTimeSlot();
	}
	
	TimeSlot getTimeSlot(int hours, int minutes){
		
		for (TimeSlot slot : plan){
			if (slot.contains(hours, minutes)){
				return slot;
			}
		}
		return null;

	}
	
	boolean containsOverlaps(){
		
		//PigeonHole priciple!!! xD we are cleaa
		for(int i=0;i<plan.size()-1;i++){
			if (plan.get(i).overlaps(plan.get(i+1))){
				return true;
			}
		}
		return false;
	}
	
	Collection<TimeSlot> getFreeTime(){
		
		Collection<TimeSlot> free = new ArrayList<>();
		
		//den første fritiden
		free.add(new TimeSlot("Fri!",0,0, plan.get(0).getStartTime().getHour()*60+plan.get(0).getStartTime().getMinutes()));
		//tar ikke med det evt. fritiden som er fra kl 0000 natt til første appointment
		//tar heler ikke med sisste fritid D:
		for (int i=0;i<plan.size()-1;i++){
			
			int endTime = plan.get(i).getEndtime().getHour() * 60;
			endTime += plan.get(i).getEndtime().getMinutes();
			
			int startNext = plan.get(i+1).getStartTime().getHour() * 60;
			startNext += plan.get(i+1).getStartTime().getMinutes();
			
			//mellomrommet mellom disse er fritid
			//endTime er start1 for fritid(timeslot)objektet
			
			//duration
			int durationFritid = startNext - endTime;
			
			free.add(new TimeSlot("Fri!", 0, endTime, durationFritid));
			//free.add(new TimeSlot("Fri!", plan.get(i).getEndtime().getHour(), plan.get(i).getEndtime().getMinutes(), durationFritid));
		}
		
		//den siste fritiden
		free.add(new TimeSlot("Fri!",plan.get(plan.size()-1).getEndtime().getHour(),plan.get(plan.size()-1).getEndtime().getMinutes(), 24*60 - (plan.get(plan.size()-1).getEndtime().getHour()*60 + plan.get(plan.size()-1).getEndtime().getMinutes())));
			
		return free; 
	}	
}
