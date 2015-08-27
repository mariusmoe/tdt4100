package interfaces;

//made by Marius Oscar Moe 
//denne koden inneholder forbedringer overfor twitterAcount klassen under objektstrukturer.

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
			account.observers.add(this);
		}
		else{
			throw new IllegalArgumentException("kan ikke dobbelt følge");
		}
	}
	
	void unfollow(TwitterAccount account){
		if (following.contains(account)){
			this.following.remove(account);
			account.observers.remove(this);
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
	
	
	public List<TwitterAccount> getFollowers(Comparator<TwitterAccount> o1){
		//stuff...
		List<TwitterAccount> obs = observers;
		
		if (o1 == (null)){
			return observers;
		}
		else if (o1 instanceof UserNameComparator){
			Collections.sort(obs, new UserNameComparator());
			return obs;
		}
		else if (o1 instanceof FollowersCountComparator){
			Collections.sort(obs, new FollowersCountComparator());
			return obs;
		}
		else if (o1 instanceof TweetsCountComparator){
			Collections.sort(obs, new TweetsCountComparator());
			return obs;
		}
		return null;	
	}


	public int getFollowerCount() {
		return observers.size();
	}

}
