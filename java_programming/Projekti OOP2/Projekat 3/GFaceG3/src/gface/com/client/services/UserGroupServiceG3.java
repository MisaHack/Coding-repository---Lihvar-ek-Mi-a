package gface.com.client.services;

import java.util.List;

import gface.com.server.entity.GroupsG3;
import gface.com.server.entity.UserG3;
import gface.com.server.entity.UserGroupG3;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("userGroupService")
public interface UserGroupServiceG3 extends RemoteService{
	
	public UserGroupG3 createUserGroup(UserGroupG3 group);
	
	
	public List<UserGroupG3> findFollowing(UserG3 user) ;
}
