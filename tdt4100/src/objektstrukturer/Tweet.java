package objektstrukturer;


public class Tweet {
	
	//TwitterAccount twitterAccount = new TwitterAccount(null);

	String txt;
	int retweetCount;
	TwitterAccount owner;
	Tweet orgTweet;
	

	TwitterAccount activeAccount;
	
	public Tweet(TwitterAccount TwitterAccount, String s){
		this.txt = s;
		
		this.owner = TwitterAccount;
		this.activeAccount = TwitterAccount;
		this.orgTweet=null;
	}
	
	public Tweet(TwitterAccount TwitterAccount, Tweet t){
		//unntak om retweeten er fra samme konto
		
			if (TwitterAccount.equals(t.getOwner())){
				
				throw new IllegalArgumentException();
			}
			else{
					if (t.getOriginalTweet() == (null)){
						this.orgTweet=t;
					}
					else{
						this.orgTweet=t.getOriginalTweet();
					}
					
					this.owner=TwitterAccount;
					this.txt = t.getText(); 
					t.retweetCount++;
					
					this.activeAccount = TwitterAccount;	//brukes ikke?
				}
	}
	
	String getText(){
		return this.txt;
	}
	
	TwitterAccount getOwner(){
		return this.owner;
	}
	
	Tweet getOriginalTweet(){
		return orgTweet;
	}
	
	int getRetweetCount(){
		return this.retweetCount;
	}
	
	
	public static void main(final String[] args) {
		TwitterAccount moe = new TwitterAccount("moe");
		TwitterAccount quang = new TwitterAccount("quang");
		TwitterAccount fred = new TwitterAccount("fred");
		
		System.out.println(moe);
		
		Tweet tweet = new Tweet(moe,"kvittre");
		
		System.out.println(tweet.getText());
		System.out.println("owner: "+tweet.getOwner());
		System.out.println("orgTweet: "+tweet.getOriginalTweet());
		
		Tweet tweet2 = new Tweet(quang,tweet);
		
		System.out.println(tweet2.getText());
		System.out.println("owner: "+tweet2.getOwner());
		System.out.println("orgTweet2: "+tweet2.getOriginalTweet());
		
		Tweet tweet3 = new Tweet(fred,tweet);
		
		System.out.println(tweet3.getText());
		System.out.println("owner: "+tweet3.getOwner());
		System.out.println("orgTweet3: "+tweet3.getOriginalTweet());
		
		
		
		
		
	}

}
