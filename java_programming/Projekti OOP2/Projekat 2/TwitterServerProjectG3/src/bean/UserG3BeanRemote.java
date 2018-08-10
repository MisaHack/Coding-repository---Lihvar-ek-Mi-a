package bean;

import java.util.ArrayList;

import entity.UserG3;
import entity.UserTweetG3;
/**
 * @author <a href="barugdzicnenad@gmail.com">Nenad Barugdzic</a>
 */
public interface UserG3BeanRemote {

	UserG3 loginUser(String tweetname, String password);

	void logoutUser();

	boolean registerUser(String email, String name, String surname,
			String tweetname, String password, String avatar, String about,
			String birthdate);

	public ArrayList<UserTweetG3> getAllFavoriteTweets(UserTweetG3 user);
	
	public void followUser(int user_id, int follow_id) ;
	
	public ArrayList<UserG3> findFollowing(UserG3 user);

	public ArrayList<UserG3> findFollowers(UserG3 loggedUser);
	
	public ArrayList<UserG3> searchUsersByTweetname(String searchText);
	
	public UserG3 searchUsersByTweetnameFull(String searchText);
	
	public ArrayList<UserG3> findAllUsers();

	public boolean updateUser(String email, String name, String surname, String password,
			String avatar, String about);

}
