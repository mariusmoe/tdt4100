package encapsulation;



public class Nim {
	
	//ArrayList<Integer> pile = new ArrayList<Integer>();
	
	int[] piles = new int[3];
	

	
	 
	
	public Nim(int pileSize){
		
		for (int i=0; i<piles.length; i++)
		{
		  piles[i]=pileSize;
		}
		
		//pile.addAll(Arrays.asList(pileSize,pileSize,pileSize));
	}
	
	public Nim(){
		//pile.addAll(Arrays.asList(10,10,10));
		
		
		
		piles[0] = 10;
		piles[1] = 10;
		piles[2] = 10;
		//System.out.println(pile);
		//System.out.println("pile size: "+pile.size());
		System.out.println("---------------------------");
		/*for (int i=0; i<piles.length; i++)
		{
		  System.out.println(piles[i]);
		}*/
	}
	
	public void removePieces(int number, int targetPile){
		
		//System.out.println(isValidMove(number, targetPile));
		if (isGameOver()){
			throw new IllegalStateException("game over");
		}
		if(number > 0 && piles.length>=targetPile && targetPile >=0 && isValidMove(number, targetPile)){
		
			//pile.set(targetPile-1, pile.get(targetPile-1)-number);
			this.piles[targetPile]-=number;
			if (isGameOver()){
				throw new IllegalStateException("game over");
			}
			
			//System.out.println(pile);
			//System.out.println("piles: "+piles);
			/*for (int i=0; i<piles.length; i++)
			{
			  System.out.println(piles[i]);
			}*/

		}
		
		else{
			throw new IllegalArgumentException();
		}
		
		
		
	}
	boolean isValidMove(int number, int targetPile){
		
		//denne delen av koden tar minus en gang for mye... fixed :D
		//pile.set(targetPile-1, pile.get(targetPile-1)-number);
		//System.out.println("is valid: "+ (pile.get(targetPile-1)-1));
		
		if (piles[targetPile]-number<0 || number <= 0 || isGameOver()){
			return false;
		}
		else{
			return true;
		}
		
		
	}
	boolean isGameOver(){
		
		for (int pile : piles) {
		  if (pile<=0){
			 return true; 
		  }
		}
		return false;
		
		
		
	}
	
	public int getPile(int targetPile) {
		return piles[targetPile];
		
	}
	public String toString(){
		String ut = "";
		for (int i=0; i<piles.length; i++)
		{
		  ut += piles[i]+", ";
		  
		}
		
		return ut;
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Nim nim = new Nim();
		nim.removePieces(10,0);
		System.out.println("svar: "+nim.toString());
		System.out.println("getpile1: "+nim.getPile(0));
		System.out.println("getpile2: "+nim.getPile(1));
		System.out.println("getpile3: "+nim.getPile(2));
		nim.removePieces(5,0);
		System.out.println("svar: "+nim.toString());
		System.out.println("getpile1: "+nim.getPile(0));
		System.out.println("getpile2: "+nim.getPile(1));
		System.out.println("getpile3: "+nim.getPile(2));
	}

}
