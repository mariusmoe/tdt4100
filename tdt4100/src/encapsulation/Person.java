package encapsulation;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Person {
	
	 
    String name;
    String forName;
    String etterName;
    String email;
    Date Birthday;
    char Gender;
	
    public Person(){
    	
    }
    
	public void setName(String newName){

		String string = newName;
		String[] parts = string.split(" ");
		//String part1 = parts[0]; // fornavn
		//String part2 = parts[1]; // etternavn
		
		if (parts.length == 2 && parts[0].length()>2 && parts[1].length()>2 && newName.matches("[a-zæøåA-ZÆØÅ ]+")){
			this.name=newName;
			this.forName=parts[0];
			this.etterName=parts[1];
		}
		else{
			throw new IllegalArgumentException("bad name! D:");
		}
		
	}
	public String getName(){
		//setName(newName);
		return name;
	}
	
	public void setEmail(String epost){
		
		final ArrayList<String> list = new ArrayList<String>(Arrays.asList("AF", "AL", "DZ", "AS", "AD", "AO", "AI", 
				"AQ", "AG", "AR", "AM", "AW", "AU", "AT", "AZ", "BS", "BH", "BD", "BB", "BY", "BE", 
				"BZ", "BJ", "BM", "BT", "BO", "BA", "BW", "BR", "IO", "VG", "BN", "BG", "BF", "MM", 
				"BI", "KH", "CM", "CA", "CV", "KY", "CF", "TD", "CL", "CN", "CX", "CC", "CO", "KM", 
				"CK", "CR", "HR", "CU", "CY", "CZ", "CD", "DK", "DJ", "DM", "DO", "EC", "EG", "SV", 
				"GQ", "ER", "EE", "ET", "FK", "FO", "FJ", "FI", "FR", "PF", "GA", "GM", "GE", "DE", 
				"GH", "GI", "GR", "GL", "GD", "GU", "GT", "GN", "GW", "GY", "HT", "VA", "HN", "HK", 
				"HU", "IS", "IN", "ID", "IR", "IQ", "IE", "IM", "IL", "IT", "CI", "JM", "JP", "JE", 
				"JO", "KZ", "KE", "KI", "KW", "KG", "LA", "LV", "LB", "LS", "LR", "LY", "LI", "LT", 
				"LU", "MO", "MK", "MG", "MW", "MY", "MV", "ML", "MT", "MH", "MR", "MU", "YT", "MX", 
				"FM", "MD", "MC", "MN", "ME", "MS", "MA", "MZ", "NA", "NR", "NP", "NL", "AN", "NC", 
				"NZ", "NI", "NE", "NG", "NU", "KP", "MP", "NO", "OM", "PK", "PW", "PA", "PG", "PY", 
				"PE", "PH", "PN", "PL", "PT", "PR", "QA", "CG", "RO", "RU", "RW", "BL", "SH", "KN", 
				"LC", "MF", "PM", "VC", "WS", "SM", "ST", "SA", "SN", "RS", "SC", "SL", "SG", "SK", 
				"SI", "SB", "SO", "ZA", "KR", "ES", "LK", "SD", "SR", "SJ", "SZ", "SE", "CH", "SY", 
				"TW", "TJ", "TZ", "TH", "TL", "TG", "TK", "TO", "TT", "TN", "TR", "TM", "TC", "TV", 
				"UG", "UA", "AE", "GB", "US", "UY", "VI", "UZ", "VU", "VE", "VN", "WF", "EH", "YE", 
				"ZM", "ZW"));
		if(epost.length() == 0 ){
			this.email=epost;
		}
			
		else if (epost.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)+@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")){
			System.out.println(epost);
			
			String string = epost.toLowerCase();
			String[] parts = string.split("\\.|\\@");
			String part1 = parts[0]; // fornavn
			String part2 = parts[1]; // etternavn
			@SuppressWarnings("unused")
			String part3 = parts[2]; // domene
			String part4 = parts[3]; // lannkode
			System.out.println(part1 + " " + parts[1] + " " + parts[2] + " " + parts[3].toUpperCase());
			
			if (part1.equals(forName.toLowerCase()) && part2.equals(etterName.toLowerCase()) && list.contains(part4.toUpperCase())){
				this.email=epost;
				System.out.println("Eposten er endret!"+epost);
			}
			else {
				throw new IllegalStateException("fornavn/etternav eller lannkoden er feil");
			}
			
			
		}
		else{
			throw new IllegalArgumentException("bad ePost! D:");
		}
	}
	
	public String getEmail(){
		//setEmail(epost);
		return email;
	}
	
	public void setBirthday(Date dato){	
		
		Date nowDate = new Date();
		System.out.println(nowDate);
		
		if (dato.before(nowDate)){
			this.Birthday=dato;
			System.out.println("dato er gyldig"+dato);
		}
		else{
			throw new IllegalArgumentException("datoen er etter i dag");
		}	
	}
	public Date getBirthday(){
		//setBirthday(dato);
		return Birthday;
	}
	
	
	public void setGender(char a){
		
		if (a == 'M'){
			this.Gender='M';
		}
		else if (a == 'F'){
			this.Gender='F';
		}
		else if (a == '\0'){
			this.Gender='\0';
		}
		else{
			throw new IllegalArgumentException("gender må være m/f/0");
		}
		System.out.println(Gender);
		
	}
	
	public Character getGender(){
		//setGender(a);
		return Gender;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person person = new Person();
		person.setName("Ola Nordmann");
		person.setEmail("ola.nordmann@ntnu.no");
		person.setEmail("ola.nordmann@ntnu.no");
		//person.setEmail("oscar.moeee@gmail.AF");
		//System.out.println(person);
		
	

		                  
		  @SuppressWarnings("deprecation")
		Date myDate = new Date(112, 3, 21);
		  person.setBirthday(myDate);
		  
		  person.setGender('M');
		  person.setGender('F');
		  person.setGender('\0');
		  //person.setGender('s');  	vil krasje programment



		  
		//  Date myDate2 = new Date(120, 3, 21);
		  //person.setBirthday(myDate2);
		  
		
	}

}
