package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * Entity implementation class for Entity: CommentG3
 *
   * @author <a href="barugdzicnenad@gmail.com">Nenad Barugdzic</a>
 */
@Entity
@NamedQueries({	
	@NamedQuery(name = "CommentG3.getCommentForTweet", query = "SELECT c from CommentG3 c where c.tweets = :tweet"),
})
public class CommentG3 implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int comment_id;
	@Column(length = 140)
	private String commentText;
	@ManyToOne(optional = false)
	private TweetG3 tweets;
	@ManyToOne(optional = false)
	private UserG3 users;
	
	public void setComment_id(int comment_id){
		this.comment_id = comment_id;
	}
   
	public int getComment_id(){
		return comment_id;
	}
	
	public void setCommentText(String commentText){
		this.commentText = commentText ;
	}
	
	public String getCommentText(){
		return commentText;
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
