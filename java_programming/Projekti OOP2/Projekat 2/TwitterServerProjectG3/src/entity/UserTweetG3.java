package entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * Entity implementation class for Entity: UserTweetG3
 *
 * @author <a href="barugdzicnenad@gmail.com">Nenad Barugdzic</a>
 */
@Entity

/**
 *  @author Nemanja Dragin
 *
 * Named queries for UserTweetG3
 */
@NamedQueries({	
	@NamedQuery(name = "UserTweetG3.getAllFavorites", query = "SELECT ut FROM UserTweetG3 ut WHERE ut.users = :user and ut.favorite = true"),
	@NamedQuery(name = "UserTweetG3.getAllFavoritesForTweet", query = "SELECT ut FROM UserTweetG3 ut WHERE ut.users = :user and ut.tweets = :tweet and ut.favorite = true"),
	@NamedQuery(name = "UserTweetG3.getAllRetweetsForTweet", query = "SELECT ut FROM UserTweetG3 ut WHERE ut.users = :user and ut.tweets = :tweet and ut.retweeted = true"),
})

public class UserTweetG3 implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int user_tweet_id;
	private boolean favorite;
	private boolean retweeted;
	@ManyToOne(optional = false)
	private TweetG3 tweets;
	@ManyToOne(optional = false)
	private UserG3 users;
	
	public void setUser_tweet_id(int user_tweet_id){
		this.user_tweet_id = user_tweet_id;
	}
	
	public int getUser_tweet_id(){
		return user_tweet_id;
	}
	
	public void setFavorite(boolean favorite){
		this.favorite = favorite;
	}
	
	public boolean getFavorite(){
		return favorite;
	}
	
	public void setRetweeted(boolean retweeted){
		this.retweeted = retweeted;
	}
	
	public boolean getRetweeted(){
		return retweeted;
	}
	public void setTweets(TweetG3 tweets){
		this.tweets = tweets;
	}
	
   public TweetG3 getTweets(){
	   return tweets;
   }
   
	public void setUsers(UserG3 users){
		this.users = users;
	}
	
   public UserG3 getUsers(){
	   return users;
   }
   
}
