package gface.com.client.services;

import java.sql.Date;
import java.util.List;

import gface.com.server.entity.UserG3;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface UserServiceAsync {
	
	public void login(String username, String password, AsyncCallback<UserG3> result);

	void register(UserG3 user, AsyncCallback<UserG3> callback);
	
	public void findUsers(String user, AsyncCallback<List<UserG3>> callback);
}
