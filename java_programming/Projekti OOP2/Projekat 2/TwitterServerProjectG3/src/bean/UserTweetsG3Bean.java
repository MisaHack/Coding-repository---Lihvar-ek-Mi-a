package bean;

import java.util.ArrayList;
import java.util.logging.Logger;

import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entity.TweetG3;
import entity.UserG3;
import entity.UserTweetG3;

/**
 * Session Bean implementation class UserTweetsG3Bean
 * @author <a href="barugdzicnenad@gmail.com">Nenad Barugdzic</a>
 */
@Stateful
@Remote(UserTweetsG3BeanRemote.class)
public class UserTweetsG3Bean implements UserTweetsG3BeanRemote {

	@PersistenceContext(name = "TwitterServerPojectG3")
	private EntityManager em;
	private static final Logger logger = Logger.getLogger(TweetG3Bean.class.getName());
    /**
     * Default constructor. 
     */
    public UserTweetsG3Bean() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void favoriteTweet(UserTweetG3 fav){
    	em.persist(fav);
    }
    
    @Override
    public TweetG3 retweet(UserTweetG3 retweet){
    	em.persist(retweet);
    	return retweet.getTweets();
    }
    
	@Override
	public ArrayList<UserTweetG3> getAllFavoritesForTweet(UserG3 loggedUser, TweetG3 tweet) {
		TypedQuery<UserTweetG3> tq = em.createNamedQuery("UserTweetG3.getAllFavoritesForTweet", UserTweetG3.class);
		tq.setParameter("user", loggedUser);
		tq.setParameter("tweet", tweet);
		return (ArrayList<UserTweetG3>)tq.getResultList();
	}
	
	@Override
	public ArrayList<UserTweetG3> getAllRetweetsForTweet(UserG3 loggedUser, TweetG3 tweet) {
		TypedQuery<UserTweetG3> tq = em.createNamedQuery("UserTweetG3.getAllRetweetsForTweet", UserTweetG3.class);
		tq.setParameter("user", loggedUser);
		tq.setParameter("tweet", tweet);
		return (ArrayList<UserTweetG3>)tq.getResultList();
	}
}
