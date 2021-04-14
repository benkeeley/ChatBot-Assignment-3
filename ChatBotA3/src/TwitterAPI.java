
import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.api.TweetsResources;
import twitter4j.auth.AccessToken;

public class TwitterAPI {
Twitter twitter;
ResponseList<Status> timelineStatusList;
ResponseList<Status> favouritesStatusList;
	
	TwitterAPI(String user) throws TwitterException{
		twitter = new TwitterFactory().getInstance();
		  // Twitter Consumer key & Consumer Secret
	    twitter.setOAuthConsumer("XXXXXXXXXXXXXXXXXXX","XXXXXXXXXXXXXXXXXXXXXXXXXXXX");
	    // Twitter Access token & Access token Secret
	  twitter.setOAuthAccessToken(new AccessToken("XXXXXXXXXXXXXXXXXXXXXXXXX", "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"));
	 
	  // Getting Twitter Timeline using Twitter4j API
	  try{
      timelineStatusList = twitter.getUserTimeline(user);
      favouritesStatusList = twitter.getFavorites(user);}
	  
	  catch(TwitterException e){
		throw e;
	  }
	}
	
	
	public String getMostRecentTweet() {
	return timelineStatusList.get(0).getText();
	}
	
	
	public String getRandomTweet() {
		
		int rnd = (int)(Math.random() * (timelineStatusList.size()-1));
		return timelineStatusList.get(rnd).getText();
		
	}
	
    public String getRandomFavourite() {
    	
	    int rnd = (int)(Math.random() * (favouritesStatusList.size()-1));
	  
	    System.out.println("Size is " + favouritesStatusList.size());
		
		return favouritesStatusList.get(rnd).getText() + " by Twitter User: " + favouritesStatusList.get(rnd).getUser().getScreenName();
    	
    }
	
	public String getMostRecentFavourite() {
		return favouritesStatusList.get(0).getText() + " by Twitter User: " + favouritesStatusList.get(0).getUser().getScreenName();
	}
	
	public String getSpecificTweet(long a)  {
		
		try {
		TweetsResources twi = twitter.tweets();
		return twitter.lookup(a).get(0).getText();
		}
		catch(TwitterException e) {
			
			return "Tweet unaccessible";
		}
		
	}
	
}
