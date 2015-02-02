package python;

//import java.util.Scanner;

public class oving0 {
	
	double r1x1 = 0;
	double r1y1 = 0;
	double r1x2 = 0;
	double r1y2 = 0;
	double r2x1 = 0;
	double r2y1 = 0;
	double r2x2 = 0;
	double r2y2 = 0;
			 
	public boolean intervalsOverlap(double n1, double n2, double m1, double m2){
		return !(n1 > m2 || n2 < m1);
	}
	
	public boolean rectanglesOverlap(){
		return intervalsOverlap(r1x1, r1x2, r2x1, r2x2) && intervalsOverlap(r1y1, r1y2, r2y1, r2y2);
	}
	
	public String rectangle2String(double x1,double y1,double x2,double y2){
		return "("+ x1 + "," + y1 + ")" + ","+"("+x2+","+y2+")";
	}
	/*
	public void main(){
		Scanner scanner = new Scanner(System.in);
		
		while(true){
			System.out.println("Rect1: " + rectangle2String(r1x1, r1y1, r1x2, r1y2));
			System.out.println("Rect1: " + rectangle2String(r2x1, r2y1, r2x2, r2y2));
			String token =scanner.nextLine();
			if(token.equals("overlapse?")){
				System.out.println(rectanglesOverlap());
			}
			else if(token.equals("exit")){
				break;
			}
			else{
				int pos = token.indexOf("=");
				if (pos >= 4){
					int val = Integer.valueOf(token.substring(pos));
				}
				else if (token.startsWith(r1y1)){
					r1y1=val;
				}
				
			}
		}
	}
			 
			
			
			 
			def main():
			    while (True):
			        print("Rect1: " + rectangle2String(r1x1, r1y1, r1x2, r1y2))
			        print("Rect2: " + rectangle2String(r2x1, r2y1, r2x2, r2y2))
			        token = raw_input(" > ")
			        if token == "overlaps?":
			            print(rectanglesOverlap())
			        elif token == "exit":
			            break
			        else:
			            pos = token.find("=")
			            if pos >= 4:
			                val = float(token[pos + 1 :])
			                if token.startswith("r1x1"):
			                    r1x1 = val
			                elif token.startswith("r1y1"):
			                    r1y1 = val
			                elif token.startswith("r1x2"):
			                    r1x2 = val
			                elif token.startswith("r1y2"):
			                    r1y2 = val
			                elif token.startswith("r2x1"):
			                    r2x1 = val
			                elif token.startswith("r2y1"):
			                    r2y1 = val
			                elif token.startswith("r2x2"):
			                    r2x2 = val
			                elif token.startswith("r2y2"):
			                    r2y2 = val
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Oving0 oving0 = new Oving0();
//		oving0.main();
	}

}
