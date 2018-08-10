package gface.com.client.services;

import java.sql.Date;
import java.util.List;

import gface.com.server.entity.UserG3;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("userService")
public interface UserService extends RemoteService {
	public UserG3 register(UserG3 user);
	
	public UserG3 login(String username, String password);
	
	public List<UserG3> findUsers(String user);

}
