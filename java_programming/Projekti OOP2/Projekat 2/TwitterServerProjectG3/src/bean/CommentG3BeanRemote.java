package bean;

import java.util.ArrayList;

import javax.ejb.Remote;

import entity.CommentG3;
import entity.TweetG3;

@Remote
public interface CommentG3BeanRemote {

    public ArrayList<CommentG3> getAllCommentsForTweetS(TweetG3 tweet);
    
    public void createComment(CommentG3 com);
}
