package eksamen2013ord;

public abstract class TaxEntity {
	
	private final String idnr;
	protected String navn;
	protected Float skatteprosent;
	protected Integer inntekt;
	protected Integer fradrag;
	protected Integer gjeld;
	
	/*public TaxEntity(String s){
		this.idnr = s;
	}
*/
	
	boolean checkPositive(int i){
		if(i<0){
			return false;
		}
		return true;
	}
	boolean checkName(String s){
		if(s.length()>=3){
			return true;
		}
		return false;
	}
	boolean checkPercentage(int i){
		if(i>0 && i<100){
			return true;
		}
		return false;
	}
	protected abstract boolean checkId(String s);

	
}
