package eksamen2012kont;

public class v {
	//public int v0;//0//1	-2 
	//public int v1 = v0++;//0	-0
//	public int v2; //0	-1
	
	public int c0, c1=c0--, c2=c1+2;
	
	public v(){
		c2 = c0++;
	}
	
	public static void main(String[] args) {
		v t = new v();
	}
}
