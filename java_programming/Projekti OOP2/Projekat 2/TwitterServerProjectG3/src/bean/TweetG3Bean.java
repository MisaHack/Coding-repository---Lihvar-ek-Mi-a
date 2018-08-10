package bean;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entity.TweetG3;
import entity.UserG3;

/**
 * Session Bean implementation class TweetG3Bean
 * @author <a href="barugdzicnenad@gmail.com">Nenad Barugdzic</a>
 */
@Stateful
@Remote(TweetG3BeanRemote.class)
public class TweetG3Bean implements TweetG3BeanRemote {
	@PersistenceContext(name = "TwitterServerPojectG3")
	private EntityManager em;
	private static final Logger logger = Logger.getLogger(TweetG3Bean.class.getName());

    /**
     * Default constructor. 
     */
    public TweetG3Bean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public ArrayList<TweetG3> getTimelineTweets(UserG3 loggedUser) {
		TypedQuery<TweetG3> tq = em.createNamedQuery("TweetG3.timelineTweets", TweetG3.class);
		tq.setParameter("loggedUser", loggedUser);
		return (ArrayList<TweetG3>)tq.getResultList();
	}
	
	@Override
	public boolean createTweet(TweetG3 tweet) {
		try{
			em.persist(tweet);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	    return true;
	}
	
	@Override
	public ArrayList<TweetG3> getTweetsForUser(UserG3 loggedUser) {
		TypedQuery<TweetG3> tq = em.createNamedQuery("TweetG3.getAllTweetsForUser", TweetG3.class);
		tq.setParameter("loggedUser", loggedUser);
		return (ArrayList<TweetG3>)tq.getResultList();
	}
}
