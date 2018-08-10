package bean;

import java.util.ArrayList;
import java.util.logging.Logger;

import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entity.CommentG3;
import entity.TweetG3;

/**
 * Session Bean implementation class CommentG3Bean
   * @author <a href="barugdzicnenad@gmail.com">Nenad Barugdzic</a>
 */
@Stateful
@Remote(CommentG3BeanRemote.class)
public class CommentG3Bean implements CommentG3BeanRemote {
	@PersistenceContext(name = "TwitterServerPojectG3")
	private EntityManager em;
	private static final Logger logger = Logger.getLogger(TweetG3Bean.class.getName());
    /**
     * Default constructor. 
     */
    public CommentG3Bean() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void createComment(CommentG3 com){
    	em.persist(com);
    }
    
    @Override
    public ArrayList<CommentG3> getAllCommentsForTweetS(TweetG3 tweet){
		TypedQuery<CommentG3> tq = em.createNamedQuery("CommentG3.getCommentForTweet", CommentG3.class);
		tq.setParameter("tweet", tweet);
		return (ArrayList<CommentG3>)tq.getResultList();
    }

}
