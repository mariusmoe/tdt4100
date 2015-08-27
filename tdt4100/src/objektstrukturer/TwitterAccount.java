package objektstrukturer;

import java.util.ArrayList;
import java.util.List;


public class TwitterAccount {

	
	String username;
	
	//int tweetCount; ikke nødvendig -> tweetTxt.size()
	int retweetCountOnThis;
	List<Tweet> tweets = new ArrayList<Tweet>();
	List<TwitterAccount> following = new ArrayList<>();
	List<TwitterAccount> observers = new ArrayList<>();
	
	public class String1 {

	}

	// dette er brukernavnet
	public TwitterAccount(String string) {
		this.username = string;
	}


	public String getUserName(){
		return username;
	}
	
	void follow(TwitterAccount account){
		if (!following.contains(account)){
			this.following.add(account);
			this.observers.add(account);
		}
		else{
			throw new IllegalArgumentException("kan ikke dobbelt følge");
		}
	}
	
	void unfollow(TwitterAccount account){
		if (following.contains(account)){
			this.following.remove(account);
			this.observers.remove(account);
		}
		
	}
	
	boolean isFollowing(TwitterAccount account){
		return following.contains(account);
	}
	
	boolean isFollowedBy(TwitterAccount account){
		
		if (account.following.contains(this)){
			return true;
		}
		else{
			return  false;
		}
	}
	
	
	public void retweet(Tweet tweet){
		try {
			tweet.getOriginalTweet().getOwner().retweetCountOnThis++;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			tweet.getOwner().retweetCountOnThis++;
		}
		Tweet tweet2= new Tweet(this, tweet);	
		this.tweets.add(0, tweet2);
	}
	
	//
	Tweet getTweet(int i){
		return this.tweets.get(i-1);
		
	}
	
	int getTweetCount(){
		return tweets.size();
		
	}
	
	int getRetweetCount(){
		return retweetCountOnThis;
	}


	public void tweet(String string) {
		
		Tweet tweet= new Tweet(this, string);	
		this.tweets.add(0, tweet);
	}

}
