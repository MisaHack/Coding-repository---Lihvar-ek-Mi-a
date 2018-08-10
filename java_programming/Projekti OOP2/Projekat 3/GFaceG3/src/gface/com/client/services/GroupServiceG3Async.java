package gface.com.client.services;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import gface.com.server.entity.GroupsG3;
import gface.com.server.entity.UserG3;

public interface GroupServiceG3Async {
	public void createGroup(GroupsG3 group, AsyncCallback<GroupsG3> callback);
	
	public void findUserGroups(UserG3 user, AsyncCallback<List<GroupsG3>> callback);

}
