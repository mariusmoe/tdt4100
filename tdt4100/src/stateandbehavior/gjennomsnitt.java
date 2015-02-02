package stateandbehavior;

public class gjennomsnitt {
	
	int tall=0;
	int antallTall=1;
	double snitt=0.0000;
	boolean first=false;
	
	void nextNumber(int value){
		if (!first){
			tall=value+tall;
			first=true;
			
		}
		else{
			tall=tall+value;
			antallTall=antallTall+1;
		}
	}
	
	double getGjennomsnitt(){
		snitt=tall/antallTall;
		return snitt;
	}
	


	@Override
	public String toString() {
		return "gjennomsnitt [tall=" + tall + ", antallTall=" + antallTall
				+ ", snitt=" + snitt + ", first=" + first
				+ ", getGjennomsnitt()=" + getGjennomsnitt() + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		gjennomsnitt Gjennomsnitt = new gjennomsnitt();
		
		//System.out.println(Gjennomsnitt);
		Gjennomsnitt.nextNumber(0);
		System.out.println(Gjennomsnitt);
		Gjennomsnitt.nextNumber(3);
		System.out.println(Gjennomsnitt);
		Gjennomsnitt.nextNumber(8);
		System.out.println(Gjennomsnitt);
		Gjennomsnitt.nextNumber(9);
		System.out.println(Gjennomsnitt);
		
	}

}
