package gface.com.client.services;

import java.util.List;

import gface.com.server.entity.PostG3;
import gface.com.server.entity.UserG3;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("postService")
public interface PostServiceG3 extends RemoteService{

	public PostG3 createPost(PostG3 post);
	
	public List<PostG3> findPostsCreatedForUser(UserG3 user);
	
	public List<PostG3> findPostsCreatedByUser(UserG3 user);
}
