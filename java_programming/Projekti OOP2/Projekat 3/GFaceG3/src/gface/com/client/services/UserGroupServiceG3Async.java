package gface.com.client.services;

import java.util.List;

import gface.com.server.entity.GroupsG3;
import gface.com.server.entity.UserG3;
import gface.com.server.entity.UserGroupG3;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface UserGroupServiceG3Async {
	
	public void createUserGroup(UserGroupG3 group, AsyncCallback<UserGroupG3> callback);
	
	
	public void findFollowing(UserG3 user, AsyncCallback<List<UserGroupG3>> callback) ;
}
