package gface.com.client.services;

import java.util.List;

import gface.com.server.entity.PostG3;
import gface.com.server.entity.UserG3;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface PostServiceG3Async {

	public void createPost(PostG3 post, AsyncCallback<PostG3> callback);
	
	public void findPostsCreatedByUser(UserG3 user, AsyncCallback<List<PostG3>> callback);
	
	public void findPostsCreatedForUser(UserG3 user, AsyncCallback<List<PostG3>> callback);
}
