package interfaces;

public class Person1 implements Named {
	
	
	String givenName;
	String familyName;
	
	Person1(String s1, String s2){
		this.givenName = s1;
		this.familyName = s2;
	}
	

	@Override
	public void setGivenName(String s) {
		// TODO Auto-generated method stub
		this.givenName = s;

	}
	
	@Override
	public String getGivenName() {
		// TODO Auto-generated method stub
		return this.givenName;
	}

	@Override
	public void setFamilyName(String s) {
		// TODO Auto-generated method stub
		this.familyName = s;
	}
	
	@Override
	public String getFamilyName() {
		// TODO Auto-generated method stub
		return this.familyName;
	}

	@Override
	public void setFullName(String s) {
		// TODO Auto-generated method stub
		String string1 = s;
		String[] parts1 = string1.split(" ");
		String fornavn = parts1[0]; 	// Fornavn
		String etternavn = parts1[1]; 	// Etternavn
		this.givenName = fornavn;
		this.familyName = etternavn;
		
		
	}

	@Override
	public String getFullName() {
		// TODO Auto-generated method stub
		return this.givenName + " " + this.familyName;
	}


	

}
