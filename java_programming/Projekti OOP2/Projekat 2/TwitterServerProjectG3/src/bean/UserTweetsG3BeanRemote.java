package bean;

import java.util.ArrayList;

import javax.ejb.Remote;

import entity.TweetG3;
import entity.UserG3;
import entity.UserTweetG3;

/*
* @author <a href="barugdzicnenad@gmail.com">Nenad Barugdzic</a>
*/
@Remote
public interface UserTweetsG3BeanRemote {
	
    public void favoriteTweet(UserTweetG3 fav);
    
    public TweetG3 retweet(UserTweetG3 retweet);
    
	public ArrayList<UserTweetG3> getAllFavoritesForTweet(UserG3 loggedUser, TweetG3 tweet);
	
	public ArrayList<UserTweetG3> getAllRetweetsForTweet(UserG3 loggedUser, TweetG3 tweet);

}
