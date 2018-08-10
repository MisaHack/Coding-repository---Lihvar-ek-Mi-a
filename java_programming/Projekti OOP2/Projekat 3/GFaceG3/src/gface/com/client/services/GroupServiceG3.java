package gface.com.client.services;

import gface.com.server.entity.GroupsG3;
import gface.com.server.entity.UserG3;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("groupService")
public interface GroupServiceG3 extends RemoteService{
	public GroupsG3 createGroup(GroupsG3 group);
	
	public List<GroupsG3> findUserGroups(UserG3 user);


}
