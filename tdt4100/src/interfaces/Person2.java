package interfaces;

public class Person2 implements Named {

	
	String fullName;
	
	Person2(String s){
		this.fullName=s;
	}
	@Override
	public void setGivenName(String s) {
		
		
		String string = fullName;
		String[] parts1 = string.split(" ");
		String part1 = parts1[0]; // 
		String part2 = parts1[1]; // 
		
		part1=s; 		//bytter ut det tidligere fornavnet med et nytt et
		this.fullName= part1 + " " + part2;
		

	}
	
	@Override
	public String getGivenName() {
		String string = fullName;
		String[] parts1 = string.split(" ");
		String part1 = parts1[0]; // 
		return part1;
	}

	@Override
	public void setFamilyName(String s) {
		
		String string = fullName;
		String[] parts1 = string.split(" ");
		String part1 = parts1[0]; // 
		String part2 = parts1[1]; // 
		
		part2=s; 		//bytter ut det tidligere etternavnet med et nytt et
		this.fullName= part1 + " " + part2;

	}
	
	@Override
	public String getFamilyName() {
		String string = fullName;
		String[] parts1 = string.split(" ");
		String part2 = parts1[1]; // 
		return part2;
	}

	@Override
	public void setFullName(String s) {
		// TODO Auto-generated method stub
		
		this.fullName=s;
	}

	@Override
	public String getFullName() {
		// TODO Auto-generated method stub
		return this.fullName;
	}


}
