package entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Tweet
 *
 * @author <a href="barugdzicnenad@gmail.com">Nenad Barugdzic</a>
 */
@Entity
@NamedQueries({	
	@NamedQuery(name = "TweetG3.timelineTweets", query = "SELECT t from TweetG3 t where t.users in (select u from UserG3 u join u.followers f where f = :loggedUser) or t.users = :loggedUser order by t.createDate desc"),
	@NamedQuery(name = "TweetG3.getAllTweetsForUser", query = "select t from TweetG3 t where t.users = :loggedUser order by t.createDate desc")
})
public class TweetG3 implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int tweet_id;
	@Column(length = 140)
	private String tweetText;
	
	//>MODIFIED<
	//
	//Lakse mi je da baratam sa Date jer znam kako.
	//
	private Timestamp createDate;
	//
	//@author <a href="mailto:lihvarcekmisa@yahoo.com">Lihvarcek Misa</a>
	//
	//>END MODIFIED<
	//private Date createDate;
	@OneToMany(mappedBy = "tweets")
	private List<CommentG3> comments;
	@OneToMany(mappedBy = "tweets")
	private List<UserTweetG3> tweets;
	@ManyToOne(optional = false)
	private UserG3 users;
	
	public void setTweet_id(int tweet_id){
		this.tweet_id = tweet_id;
	}
	
	public int getTweet_id(){
		return tweet_id;
	}
	
	public void setTweetText(String tweetText){
		this.tweetText = tweetText;
	}
	
	public String getTweetText(){
		return tweetText;
	}
	
	public void setCreateDate(Timestamp createDate){
		this.createDate = createDate;
	}
	
	public Timestamp getCreateDate(){
		return createDate;
	}
	
	public void setComments(List<CommentG3> comments){
		this.comments = comments;
	}
	
	public List<CommentG3> getComments() {
		return comments;
	}
	
	public void setTweets(List<UserTweetG3> tweets) {
		this.tweets = tweets;
	}
	
	public List<UserTweetG3> getTweets(){
		return tweets;
	}
	
	public void setUsers(UserG3 users){
		this.users = users;
	}
	
   public UserG3 getUsers(){
	   return users;
   }
}
