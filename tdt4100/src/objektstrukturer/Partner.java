package objektstrukturer;

public class Partner {

	String name;
	
	Partner partnerMed=null;
	
	Partner(String s){
		this.name=s;
	}
	 String getName(){
		return name;
	}
	 Partner getPartner(){
		return partnerMed;
	}
	void setPartner(Partner p){
		
		try{
			if(!(p.partnerMed == null)){
				partnerMed.setPartner(null);
				p.getPartner().setPartner(null);
			}
		}
		catch (NullPointerException e){}
			
	//hvorfor denne fargen???
	if (p == null){
		partnerMed.partnerMed = null;
		this.partnerMed=null;
	}
	else{
		this.partnerMed=p;	//denne partneren er partner med p
		p.partnerMed=this; //partner er partner med this(denne) partneren
		}
	}
		
	
	public static void main(final String[] args) {
		
		Partner p1 = new Partner("p1");
		Partner p2 = new Partner("p2");
		Partner p3 = new Partner("p3");
	    Partner p4 = new Partner("p4");
		
		p1.setPartner(p2);
		p3.setPartner(p4);
		System.out.println("p1 sin partner : " + p1.getPartner());
		System.out.println("p2 sin partner : " + p2.getPartner());
		System.out.println("p3 sin partner : " + p3.getPartner());
		System.out.println("p4 sin partner : " + p4.getPartner());
		System.out.println("---------------------------------------------");
		
		p1.setPartner(p3);
		
		System.out.println("p1 sin partner : " + p1.getPartner());
		System.out.println("p2 sin partner : " + p2.getPartner());
		System.out.println("p3 sin partner : " + p3.getPartner());
		System.out.println("p4 sin partner : " + p4.getPartner());
		System.out.println("---------------------------------------------");
	
		p1.setPartner(null);
		System.out.println("p1 sin partner : " + p1.getPartner());
		System.out.println("p2 sin partner : " + p2.getPartner());
		System.out.println("p3 sin partner : " + p3.getPartner());
		System.out.println("p4 sin partner : " + p4.getPartner());
		
		
		
	}


}
