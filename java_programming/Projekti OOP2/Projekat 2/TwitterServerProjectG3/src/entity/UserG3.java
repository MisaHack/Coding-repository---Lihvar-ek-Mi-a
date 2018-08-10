package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: UserG3
 *
  * @author <a href="barugdzicnenad@gmail.com">Nenad Barugdzic</a>
 */
@Entity
@NamedQueries({	
	@NamedQuery(name = "UserG3.login", query = "SELECT u FROM UserG3 u WHERE u.tweetname = :tweetname AND u.password = :password"),
	@NamedQuery(name = "UserG3.findAll", query = "SELECT u FROM UserG3 u"),
	@NamedQuery(name = "UserG3.searchUsersByTweetname", query = "SELECT u FROM UserG3 u where lower(u.tweetname) like :searchText order by u.tweetname"),
	@NamedQuery(name = "UserG3.findFollowing", query = "SELECT u FROM UserG3 u join u.followers f where f= :user "),
	@NamedQuery(name = "UserG3.findFollowers", query = "SELECT f FROM UserG3 u join u.followers f where u= :loggedUser ")
})
@NamedNativeQueries({
	@NamedNativeQuery(name = "UserG3.addFollowers", query = "insert into userg3_userg3 values($1 ,$2)")
})
public class UserG3 implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	//>MODIFIED<
	//@GeneratedValue
	//
	//Smatram da je bolje da ne budu automatski generisani kljucevi
	//za User-a jer u suprotnom ne mogu znati koje User-e sam 
	//ubacio u bazu a koje nisam.
	//
	//
	@Id
	@GeneratedValue
	private int id;
    //
	//rekao bih da je 'id' suvisno polje a da je ovo kljuc.
	//bitno mi je zbog Filldatabase!
	//
	//@author <a href="mailto:lihvarcekmisa@yahoo.com">Lihvarcek Misa</a>
	@Column(nullable=false, unique=true, length = 20)
	private String tweetname;
	//>END MODIFIED<
	
	@Column(nullable = false, length = 20)
	private String name;
	@Column(nullable = false, length = 20)
	private String surname;
	@Column(nullable = true, length = 50)
	private String email;
	@Column(nullable = true)
	private String avatar;
	@Column(nullable = true, length = 140)
	private String about;
	@Column(nullable = false, length = 20)
	private String password;
	@Column(nullable = false)
	private String birthdate;
	@ManyToMany
	private List<UserG3> followers;
	@OneToMany(mappedBy = "users")
	private List<CommentG3> comments;
	@OneToMany(mappedBy = "users")
	private List<UserTweetG3> userTweets;
	@OneToMany(mappedBy = "users")
	private List<TweetG3> tweets;
    
	/*
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return id;
	}
	*/
	
	public int getId(){
		return id;
	}
	
	public void setTweetname(String tweetname){
		this.tweetname = tweetname;
	}
	
	public String getTweetname(){
		return tweetname;
	}
   
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setSurname(String surname){
		this.surname = surname;
	}
	
	public String getSurname(){
		return surname;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setAvatar(String avatar){
		this.avatar = avatar;
	}
	
	public String getAvatar(){
		return avatar;	
	}
	
	public void setAbout(String about){
		this.about = about;
	}
	
	public String getAbout(){
		return about;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setBirtdate(String birthdate) {
		this.birthdate = birthdate;
	}
	
	public String getBirthdate(){
		return birthdate;
	}
	
	public void setFollowers(List<UserG3> followers){
		this.followers = followers;
	}
	
	public List<UserG3> getFollowers() {
		return followers;
	}
	
	public void setComments(List<CommentG3> comments){
		this.comments = comments;
	}
	
	public List<CommentG3> getComments() {
		return comments;
	}
	
	public void setUserTweets(List<UserTweetG3> userTweets) {
		this.userTweets = userTweets;
	}
	
	public List<UserTweetG3> getUserTweets(){
		return userTweets;
	}
	
	public void setTweets(List<TweetG3> tweets) {
		this.tweets = tweets;
	}
	
	public List<TweetG3> getTweets(){
		return tweets;
	}
} 
