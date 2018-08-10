package bean;

import java.util.ArrayList;

import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entity.UserG3;
import entity.UserTweetG3;

/**
 * Session Bean implementation class UserG3Bean
 * @author <a href="barugdzicnenad@gmail.com">Nenad Barugdzic</a>
 */
@Stateful
@Remote(UserG3BeanRemote.class)
public class UserG3Bean implements UserG3BeanRemote {

	private UserG3 loggedUser;
	@PersistenceContext(name = "TwitterServerPojectG3")
	private EntityManager em;
	
	/**
	 * @author Nenad Barugdzic
	 */
	@Override
	public UserG3 loginUser(String tweetname, String password) {
		try{
			TypedQuery<UserG3> tq = em.createNamedQuery("UserG3.login", UserG3.class);
			tq.setParameter("tweetname", tweetname);
			tq.setParameter("password", password);
			loggedUser = tq.getSingleResult();
			return loggedUser; 
		}catch(NoResultException nre){
			return null;
		}
		
	}
	
	/**
	 * @author Nemanja Dragin
	 * Registrovanje usera
	 */
	@Override
	public boolean registerUser(String email, String name, String surname, String tweetname, String password,
			String avatar, String about, String birthdate) {
		UserG3 u =  new UserG3();
		u.setEmail(email);
		u.setName(name);
		u.setSurname(surname);
		u.setTweetname(tweetname);
	    u.setPassword(password);
	    
	    u.setAvatar(avatar);
	    u.setAbout(about);
	    u.setBirtdate(birthdate);
	    em.persist(u);
		
	    return true;
	}
	/**
	 * @author Nemanja Dragin 
	 * Ako zelimo da menjamo usera, ne mozemo da menjamo tweetname i birthday, a ostale parametre mozemo
	 * Tweetname je jedinstven i ako zelimo drugi, moramo da se registrujemo opet
	 */
	@Override
	public boolean updateUser(String email, String name, String surname, String password,
			String avatar, String about) {
		UserG3 u = em.find(UserG3.class, password);
		u.setEmail(email);
		u.setName(name);
		u.setSurname(surname);
		u.setPassword(password);
		u.setAvatar(avatar);
		u.setAbout(about);
		em.merge(u);
		
		return true;
	}
	
	/**
	 * @author Nemanja Dragin
	 * Logout trivijalno
	 */
	@Override
	@Remove
	public void logoutUser() {
		loggedUser = null;
	}
	
	@Override
	public ArrayList<UserTweetG3> getAllFavoriteTweets(UserTweetG3 user) {
		TypedQuery<UserTweetG3> tq = em.createNamedQuery("UserTweetG3.getAllFavorites", UserTweetG3.class);
		tq.setParameter("user", user);
		return (ArrayList<UserTweetG3>)tq.getResultList();
	}
	
	@Override
	public ArrayList<UserG3> findFollowing(UserG3 user) {
		TypedQuery<UserG3> tq = em.createNamedQuery("UserG3.findFollowing", UserG3.class);
		tq.setParameter("user", user);
		return (ArrayList<UserG3>)tq.getResultList();
	}
	
	@Override
	public void followUser(int user_id, int follow_id) {
		Query tq = em.createNativeQuery("insert into userg3_userg3 values(?1 ,?2)", UserG3.class);
		tq.setParameter(1, user_id);
		tq.setParameter(2, follow_id);
		tq.executeUpdate();
	}
    /**
     * Default constructor. 
     */
	
	@Override
	public ArrayList<UserG3> findFollowers(UserG3 loggedUser) {
		TypedQuery<UserG3> tq = em.createNamedQuery("UserG3.findFollowers", UserG3.class);
		tq.setParameter("loggedUser", loggedUser);
		return (ArrayList<UserG3>)tq.getResultList();
	}
	
	@Override
	public ArrayList<UserG3> searchUsersByTweetname(String searchText) {
		TypedQuery<UserG3> tq = em.createNamedQuery("UserG3.searchUsersByTweetname", UserG3.class);
		tq.setParameter("searchText", "@"+searchText.toLowerCase()+"%");
		return (ArrayList<UserG3>)tq.getResultList();
	}
	
	@Override
	public UserG3 searchUsersByTweetnameFull(String searchText) {
		try{
			TypedQuery<UserG3> tq = em.createNamedQuery("UserG3.searchUsersByTweetname", UserG3.class);
			tq.setParameter("searchText", searchText.toLowerCase());
			return tq.getSingleResult();
		}catch(NoResultException nre){
			return null;
		}
	}
	
	@Override
	public ArrayList<UserG3> findAllUsers() {
		TypedQuery<UserG3> tq = em.createNamedQuery("UserG3.findAll", UserG3.class);
		return (ArrayList<UserG3>)tq.getResultList();
	}
	
}
