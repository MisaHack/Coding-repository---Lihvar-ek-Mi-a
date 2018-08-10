package bean;

import java.util.ArrayList;

import entity.TweetG3;
import entity.UserG3;
/**
 * @author <a href="barugdzicnenad@gmail.com">Nenad Barugdzic</a>
 */
public interface TweetG3BeanRemote {
	public ArrayList<TweetG3> getTimelineTweets(UserG3 user);
	public boolean createTweet(TweetG3 tweet);
	
	public ArrayList<TweetG3> getTweetsForUser(UserG3 loggedUser);
}
